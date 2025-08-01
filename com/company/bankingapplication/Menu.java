package com.company.bankingapplication;
import java.util.Scanner;
public class Menu {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username");
        String uName=sc.nextLine();
        System.out.println("Enter password");
        String password=sc.next();
        CheckUserLogin l = new CheckUserLogin(uName, password);
        l.checkUserLogin(uName, password);
        sc.close();
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
                    WriteDetails write = new WriteDetails(firstName, lastName, username, password, accountNum, initialDeposit);
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
            Transaction t = new Transaction();
            System.out.println("Enter Account Number:");
            String accountNum = sc.nextLine();
            System.out.println("Deposit Amount:");
            double Deposit = sc.nextDouble();
            sc.nextLine();
            t.readCustomerFile(accountNum);
            t.deposit(Deposit);
        } else if(input==6){
            Transaction t = new Transaction();
            System.out.println("Enter Account Number:");
            String accountNum = sc.nextLine();
            System.out.println("Withdraw Amount:");
            double Deposit = sc.nextDouble();
            sc.nextLine();
            t.readCustomerFile(accountNum);
            t.withdraw(Deposit);
        } else if(input==8){
            break;
        }
    }
}

    public static void userMenu(Scanner sc, String uNam) {
        while(true){
            System.out.println("1. Check Balance");
            System.out.println("4. Trangition details");
            System.out.println("5. Logout");
            int input=sc.nextInt();
            if (input==1){
                CheckBalance c=new CheckBalance();
                double balance=c.readAll(uNam);
                System.out.println("Balance: "+ balance);
            } 
            else if(input==5){
                break;
            }
        }
    }

}
