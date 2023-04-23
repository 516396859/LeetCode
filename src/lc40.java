import org.junit.Test;

import java.util.*;

public class lc40 {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    int sum = 0;
    public void dfs(int[] can,int target,int step){
        if(sum==target){
            ArrayList<Integer> clone = (ArrayList)temp.clone();
            res.add(clone);
            return;
        }
        if(sum>target || step>can.length){
            return;
        }
        int pre = -1;
        for (int i = step; i < can.length; i++) {
            if(can[i]==pre){
                continue;
            }
            pre = can[i];
            sum+=can[i];
            temp.add(can[i]);
            dfs(can,target,i+1);
            sum-=can[i];
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return res;
    }
    @Test
    public void test(){
        lc40 lc = new lc40();
        List<List<Integer>> lists = lc.combinationSum2(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
