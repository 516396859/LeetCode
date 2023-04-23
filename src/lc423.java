import org.junit.Test;

public class lc423 {
    public String originalDigits(String s) {
        //one two three fore five six seven eight nine ten
        // o   w    h    f    v    x    s     g    i    t
        // 8   4    1    7    6    2    5     3    9    10
        int[] arr = new int[26];
        int[] res = new int[11];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c-'a']++;
        }

        // 有多少个h就有多少个3
        res[3] = arr['h'-'a'];
        arr['h'-'a'] -= res[3];
        if(res[3]!=0){
            arr['e'-'a']-=res[3]*2;
            arr['r'-'a']-=res[3];
            arr['t'-'a']-=res[3];
        }

        return "";

    }

    @Test
    public void test(){
        lc423 lc = new lc423();
        String res = lc.originalDigits("owoztneoer");
        System.out.println(res);
    }
}
