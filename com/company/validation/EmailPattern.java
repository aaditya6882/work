package com.company.validation;
import java.util.regex.*;
public class EmailPattern extends Vaildate{
    public void checkEmail(){
        // giving pattern for email
    String patternEmail= "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.]+$";
    String email=getName();
    // matching the pattern for email
    if (Pattern.matches(patternEmail, email)) {
            System.out.println("Your email is correct");
        } else {
            System.out.println("Invalid email address");
        }
}
}