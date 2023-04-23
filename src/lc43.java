import org.junit.Test;

import java.util.List;

public class lc43 {
    public String multiply(String num1, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
        return (n1*n2)+" ";
    }

    @Test
    public void my_test() {
        lc43 lc = new lc43();
        String res = lc.multiply("123","100");
        System.out.println(res);
    }

}
