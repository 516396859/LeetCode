import org.junit.Test;

import java.util.ArrayDeque;

public class lc115 {
    @Test
    public void my_test() {
        Solution3 lc = new Solution3();
        String s = lc.reverseWords("i  love you");
        System.out.println(s);
    }
}

class Solution3 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] s1 = s.split(" ");
        String res="";
        for(int i=s1.length-1;i>=0;i--){
            if(!s1[i].equals("")){
                res+=s1[i];
                res+=" ";
            }
        }
        return res.trim();
    }
}