import java.util.Scanner;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = sc.next();

        EmailPattern p = new EmailPattern();
        p.setName(email);
        p.validateEmail(); // explicitly validate here
    }
}

class Vaildate {
    private String email;
    public void setName(String email) {
        this.email = email;
    }
    public String getName() {
        return email;
    }
}

class EmailPattern extends Vaildate {
    public void validateEmail() {
        String patternEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.]+$";
        String email = getName();
        if (Pattern.matches(patternEmail, email)) {
            System.out.println("Your email is correct");
        } else {
            System.out.println("Invalid email address");
        }
    }
}
