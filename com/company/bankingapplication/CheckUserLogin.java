package com.company.bankingapplication;
import java.util.Scanner;

class CheckUserLogin extends Login {
    public CheckUserLogin(String uName, String password) {
        super(uName, password);
    }

    public void checkUserLogin(String userName, String userpassword){
        Menu m = new Menu();
        ReadCostumer r = new ReadCostumer();
        Scanner sc = new Scanner(System.in);

        if (userName.equals("admin") && userpassword.equals("admin123")) {
            m.adminMenu(sc);
        } else if (r.validateUser(userName, userpassword)) {
            m.userMenu(sc, getUName());
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
