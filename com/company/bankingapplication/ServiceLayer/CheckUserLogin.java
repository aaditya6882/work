package com.company.bankingapplication.ServiceLayer;
import com.company.bankingapplication.Controller.Menu;
import com.company.bankingapplication.Model.Login;
import com.company.bankingapplication.dao.ReadCostumer;

import java.util.Scanner;

public class CheckUserLogin extends Login {
    public CheckUserLogin(String uName, String password) {
        super(uName, password);
    }

    public boolean  checkUserLogin(String userName, String userpassword){
        Menu m = new Menu();
        ReadCostumer r = new ReadCostumer();
        Scanner sc = new Scanner(System.in);

        if (userName.equals("admin") && userpassword.equals("admin123")) {
            m.adminMenu(sc);
            return true;
        } else if (r.validateUser(userName, userpassword)) {
            m.userMenu(sc, getUName());
            return true;
        } else {
            return false;
        }
    }
}
