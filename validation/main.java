
import java.util.*;
public class main {
    public static void main(String[] args) {
        // object of scanner
        Scanner sc =new Scanner(System.in);
        // taking input from user
        String email=sc.next();
        // validating email
        EmailPattern p=new EmailPattern();
            p.setName(email);
            p.checkEmail();
            // Inserting the mobile number
        String mobile = "9741688299";
// Validating the mobile number
        MobilePattern mp = new MobilePattern();
        mp.setMobile(mobile);
        mp.checkMobile();
        sc.close();
    }}
