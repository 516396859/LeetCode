import java.util.ArrayList;
import java.util.List;

public class lc39 {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    int sum = 0;

    public void dfs(int[] can,int target,int step){
        if(sum==target){
            ArrayList<Integer> clone = (ArrayList)temp.clone();
            res.add(clone);
            return;
        }

        if(sum>target){
            return;
        }

        for (int i = step; i < can.length; i++) {
            sum+=can[i];
            temp.add(can[i]);
            dfs(can,target,i);
            sum-=can[i];
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return res;
    }
}
