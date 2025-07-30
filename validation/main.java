
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String email=sc.next();
        EmailPattern p=new EmailPattern();
            p.setName(email);
            p.checkEmail();
        String mobile = "9741688299";

        MobilePattern mp = new MobilePattern();
        mp.setMobile(mobile);
        mp.checkMobile();
        sc.close();
    }}
