import org.junit.Test;

public class lc1734 {
    public int[] decode(int[] encoded) {
        int[] res = new int[encoded.length-1];
        for (int i = 0; i < encoded.length-1; i++) {
            res[i] = encoded[i]^encoded[i+1];
        }
        return res;
    }
    @Test
    public void test(){
        lc1734 lc = new lc1734();
        int[] decode = lc.decode(new int[]{3, 1});
        System.out.println(decode);

        System.out.println(1^2);
    }
}
