import java.util.regex.*;

class MobilePattern extends Vaildate {
    public void checkMobile() {
        String patternMobile = "^(98|97)\\d{8}$";
        String mobile = getMobile();
        if (Pattern.matches(patternMobile, mobile)) {
            System.out.println("Valid Nepal mobile number");
        } else {
            System.out.println("Invalid Nepal mobile number");
        }
    }
}