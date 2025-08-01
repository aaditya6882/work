package com.company.bankingapplication.Controller;
import com.company.bankingapplication.Model.CreateAccount;
import com.company.bankingapplication.ServiceLayer.TransactionService;
import com.company.bankingapplication.dao.CheckBalance;
import com.company.bankingapplication.dao.CheckUserLogin;
import com.company.bankingapplication.dao.DisableAccount;
import com.company.bankingapplication.dao.EnableAccount;
import com.company.bankingapplication.dao.Modify;
import com.company.bankingapplication.dao.ReadCostumer;
import com.company.bankingapplication.dao.SearchCostumer;
import com.company.bankingapplication.dao.WriteDetails;
import java.util.Scanner;
public class Menu {
    public static void main(String [] args){
        while(true) {
        Scanner sc=new Scanner(System.in);
        System.out.println("press 'exit' to exit or press 'continue' for login");
        String exit=sc.nextLine();
        if (exit.equals("exit")) {
            sc.close();
            break; 
        }
        else if(exit.equals("continue")) {
            System.out.println("Enter username");
            String uName=sc.nextLine();
            System.out.println("Enter password");
            String password=sc.next();
            CheckUserLogin l = new CheckUserLogin(uName, password);
            boolean success=l.checkUserLogin(uName, password);
            if (!success) {
                System.out.println("Login failed. Please try again.");
                continue; 
            }
        }


}
    }
   public static void adminMenu(Scanner sc) {
    while(true){
        ReadCostumer r=new ReadCostumer();
        System.out.println("1. Create Account");
        System.out.println("2. Modify Account");
        System.out.println("3. Disable Account");
        System.out.println("4. Enable Account");
        System.out.println("5. Search Customer");
        System.out.println("6. Withdraw");
        System.out.println("7. Deposit");
        System.out.println("8. Logout");

        int input = sc.nextInt();
        sc.nextLine(); 

        if(input==1){
            System.out.println("Enter First Name:");
            String firstName = sc.nextLine();

            System.out.println("Enter Last Name:");
            String lastName = sc.nextLine();

            System.out.println("Enter Username:");
            String username = sc.nextLine();
                
            if (r.usernameExists(username)) {
                System.out.println("Error: Username already exists.");
            } else {
                System.out.println("Enter Password:");
                String password = sc.nextLine();

                System.out.println("Enter Account Number:");
                String accountNum = sc.nextLine();

                if (r.accountNumberExists(accountNum)) {
                    System.out.println("Error: Account number already exists.");
                } else {
                    System.out.println("Initial Deposit:");
                    double initialDeposit = sc.nextDouble();
                    sc.nextLine(); // clear newline
                   CreateAccount c = new CreateAccount(firstName, lastName, username, password, accountNum, initialDeposit);
                    WriteDetails W = new WriteDetails(c);
                    System.out.println("Account created successfully!");
                }
            }
        } else if(input==2){
            System.out.println("Enter account number to modify:");
            String accountNum = sc.nextLine();
            System.out.println("Enter First Name:");
            String firstName = sc.nextLine();
            System.out.println("Enter Last Name:");
            String lastName = sc.nextLine();
            System.out.println("Enter Username:");
            String username = sc.nextLine();
            System.out.println("Enter Password:");
            String password = sc.nextLine();
            Modify modifyAccount = new Modify(firstName, lastName, username, password, accountNum);
        } else if(input==3){
            System.out.println("Enter Account Number to disable:");
            String accountNum = sc.nextLine();
            DisableAccount disableAccount = new DisableAccount(accountNum);
            disableAccount.disable();
        } 
        else if(input==4){
            System.out.println("Enter Account Number to enable:");
            String accountNum = sc.nextLine();
            EnableAccount enableAccount = new EnableAccount(accountNum);
            enableAccount.enable();
        }else if(input==5){
            System.out.println("Enter Account Number:");
            String accountNum = sc.nextLine();
            SearchCostumer s = new SearchCostumer();
            s.search(accountNum);
        } else if(input==7){
            TransactionService t = new TransactionService();
            System.out.println("Enter Account Number:");
            String accountNum = sc.nextLine();
            System.out.println("Deposit Amount:");
            double Deposit = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter Username:");
            String uNam = sc.nextLine();
            ReadCostumer readcostumer = new ReadCostumer();
            if(readcostumer.isUserOwnerOfAccount(uNam, accountNum)){
                t.deposit(Deposit, accountNum, uNam);
            }
        } else if(input==6){
            TransactionService t = new TransactionService();
            System.out.println("Enter Account Number:");
            String accountNum = sc.nextLine();
            System.out.println("Withdraw Amount:");
            double withdraw = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter Username:");
            String uNam = sc.nextLine();
                ReadCostumer readcostumer = new ReadCostumer();
            if(readcostumer.isUserOwnerOfAccount(uNam, accountNum)){
                t.withdraw(withdraw,   accountNum, uNam);
            }

        } else if(input==8){
            break;
        }
    }
}

    public static void userMenu(Scanner sc, String uNam) {
        while(true){
            System.out.println("1. Check Balance");
            System.out.println("2 Trangition details");
            System.out.println("3. Logout");
            int input=sc.nextInt();
            sc.nextLine(); 
            if (input==1){
                CheckBalance c=new CheckBalance();
                double balance=c.readAll(uNam);
                System.out.println("Balance: "+ balance);
            } else if(input==2){
                System.out.println("Enter Account Number:");
                String accountNum = sc.nextLine();
                TransactionService t = new TransactionService();
                t.showTransactionHistory(uNam,accountNum);
            }
            else if(input==3){
                break;
            }
        }
    }

}
