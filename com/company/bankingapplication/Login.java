package com.company.bankingapplication;

public class Login {
    private String uName;
    private String password;  

    public Login(String uName, String password) {
        this.uName = uName;
        this.password = password;
    }
    public String getUName(){
        return uName;
    }
        public String getPassword(){
        return password;
    }

}