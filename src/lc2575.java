import org.junit.Test;

public class lc2575 {
    public int[] divisibilityArray(String word, int m) {
        //依旧是前缀和
        int length = word.length();
        int[] res = new int[length];
        if((word.charAt(0)-'0')%m==0){
            res[0] = 1;
        }else {
            res[0] = 0;
        }

        for (int i = 1; i < length; i++) {
            String sub = word.substring(0,i+1);
            long num = Long.parseLong(sub);
            if(num%m==0){
                res[i] = 1;
            }else {
                res[i] = 0;
            }
        }
        return  res;
    }

    @Test
    public void test(){
        lc2575 lc = new lc2575();
        int[] ints = lc.divisibilityArray("529282143571", 4);
        for (int a : ints){
            System.out.println(a);
        }
    }
}