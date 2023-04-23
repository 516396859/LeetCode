import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class lc1641 {
//    int[] visit;
    char[] arr ;
    ArrayList<String> res;

    public void dfs(int n,String s){
        if(s.length()==n){
            res.add(s);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if(s=="" || arr[i]<=s.charAt(s.length()-1)){
                dfs(n,s+arr[i]);//注意这里是在里面加的，并不会导致递归外的s改变，因此无需回溯，会自动回溯
            }
        }

    }

    public int countVowelStrings(int n) {
        arr = new char[]{'a', 'e', 'i', 'o', 'u'};

        String s = "";
        res = new ArrayList<>();
        dfs(n,s);
        return res.size();

    }
    @Test
    public void test(){
        lc1641 lc = new lc1641();
        int i = lc.countVowelStrings(1);
        System.out.println(i);
    }
}
