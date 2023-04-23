import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc131 {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public void dfs(int n ,int step){

    }


    public List<List<String>> partition(String s) {
        int n = s.length()-1;
        dfs(n,0);
        return null;
    }

    @Test
    public void test(){
        lc131 lc = new lc131();
        lc.partition("abcd");
    }
}
