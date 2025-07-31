package com.company.validation;
import java.util.regex.*;

class MobilePattern extends Vaildate {
    public void checkMobile() {
        // pattern for mobile 
        String patternMobile = "^(98|97)\\d{8}$";
        String mobile = getMobile();
        // matching the pattern of mobile number
        if (Pattern.matches(patternMobile, mobile)) {
            System.out.println("Valid Nepal mobile number");
        } else {
            System.out.println("Invalid Nepal mobile number");
        }
    }
}