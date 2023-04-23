import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc77_2 {

    ArrayList<Integer> temp = new ArrayList<>();;
    List<List<Integer>> res = new ArrayList<>();;

    public void dfs(int n , int k,int step){
        if(temp.size()==k){
            ArrayList clone = (ArrayList)temp.clone();
            res.add(clone);
            return;
        }

        for (int i = step; i <= n ; i++) {
            temp.add(i);
            dfs(n,k,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1);
        return res;
    }

    @Test
    public void test(){
        lc77_2 lc = new lc77_2();
        List<List<Integer>> combine = lc.combine(4, 2);
        System.out.println(combine);
    }
}
