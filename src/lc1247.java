import org.junit.Test;

public class lc1247 {
    public int minimumSwap(String s1, String s2) {
        //动态规划
        int sx = 0;
        int sy = 0;
        if(s1.equals(s2)){
            return 0;
        }

        for (int i = 0; i < s1.length() ; i++) {
            if(s1.charAt(i)=='x'){
                sx ++;
            }
            if(s2.charAt(i)=='x'){
                sx ++;
            }
            if(s1.charAt(i)=='y'){
                sy ++;
            }
            if(s2.charAt(i)=='y'){
                sy ++;
            }
        }

        if(sx%2==1 || sy%2==1){
            return -1;
        }

        if(s1.charAt(0)==s2.charAt(0)){
            return minimumSwap(s1.substring(1,s1.length()),s2.substring(1,s2.length()));
        }

        return -1;
    }
    @Test
    public void test(){
        lc1247 lc = new lc1247();
        int i = lc.minimumSwap("xyxyx", "yyxxx");
        System.out.println(i);
    }
}
