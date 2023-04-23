import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc77 {

    ArrayList<Integer> temp = new ArrayList<>();;
    List<List<Integer>> res = new ArrayList<>();;
    int[] visit;

    public void dfs(int n , int k){
        if(temp.size()==k){
            ArrayList clone = (ArrayList)temp.clone();
            res.add(clone);
            return;
        }

        for (int i = 0; i < n ; i++) {
            if(visit[i]==0){
                visit[i]=1;
                temp.add(i+1);
                dfs(n,k);
                visit[i]=0;
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        visit = new int[n];
        Arrays.fill(visit,0);
        dfs(n,k);
        return res;
    }

    @Test
    public void test(){
        lc77 lc = new lc77();
        List<List<Integer>> combine = lc.combine(4, 2);
        System.out.println(combine);
    }
}
