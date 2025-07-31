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
        // Example usage: adminMenu(sc); or userMenu(sc);
        // adminMenu(sc);
        // userMenu(sc);
        sc.close();
}
    public static void adminMenu(Scanner sc) {
        while(true){
            ReadCostumer r=new ReadCostumer();
            System.out.println("1. Create Account");
            System.out.println("2. Modify Account");
            System.out.println("3. Disable Account");
            System.out.println("4. Search Customer");
            System.out.println("5. Deposit");
             System.out.println("6. Withdraw");
            System.out.println("7. Logout");
            int input=sc.nextInt();
            if(input==1){
                System.out.println("Enter First Name:");
                String firstName = sc.next();
                System.out.println("Enter Last Name:");
                String lastName = sc.next();
                System.out.println("Enter Username:");
                String username = sc.next();
                
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
                        sc.nextLine();
                WriteDetails write = new WriteDetails(firstName, lastName, username, password, accountNum, initialDeposit);
                    }
                }
            }else if(input==2){
                System.out.println("Enter First Name:");
                String firstName = sc.next();
                System.out.println("Enter Last Name:");
                String lastName = sc.next();
                System.out.println("Enter Username:");
                String username = sc.next();
                System.out.println("Enter Password:");
                String password = sc.next();
                Modify modifyAccount = new Modify(firstName, lastName, username, password, null);
            } else if(input==3){
                System.out.println("Enter Account Number to disable:");
                String accountNum = sc.next();
                DisableAccount disableAccount = new DisableAccount(accountNum);
            } else if(input==4){
                System.out.println("Enter Account Number:");
                sc.nextLine();
                String accountNum = sc.nextLine();
                SearchCostumer s = new SearchCostumer();
                s.search(accountNum);
            }  else if(input==5){
               Transaction t=new Transaction();
                System.out.println("Enter Account Number:");
                sc.nextLine();
                String accountNum = sc.nextLine();
                System.out.println("Deposit Amount:");
                double Deposit = sc.nextDouble();
                t.deposit(accountNum, Deposit);
            } 
            else if(input==6){
               Transaction t=new Transaction();
                System.out.println("Enter Account Number:");
                sc.nextLine();
                String accountNum = sc.nextLine();
                System.out.println("Withdraw Amount:");
                double Deposit = sc.nextDouble();
                t.withdraw(accountNum, Deposit);
            }
                else if(input==7){
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
