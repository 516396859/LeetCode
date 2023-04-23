import org.junit.Test;

public class lc299 {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int length = secret.length();
        int[] arrs = new int[10];
        int[] arrg = new int[10];

        StringBuffer aaa = new StringBuffer(secret);
        StringBuffer bbb = new StringBuffer(guess);

        for (int i = 0; i < length; i++) {
            if(secret.charAt(i)==guess.charAt(i)){
                a += 1;
            }else {
                arrs[secret.charAt(i)-'0'] += 1;
                arrg[guess.charAt(i)-'0'] += 1;
            }
        }

        for(int i=0;i<10;i++){
            b+=(arrs[i]>arrg[i] ? arrg[i]:arrs[i]);
        }
        return a+"A"+b+"B";
    }


    @Test
    public void my_test() {
        lc299 lc = new lc299();
        String res = lc.getHint("1807","7810");
        System.out.println(res);
    }
}
