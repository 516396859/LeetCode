import java.util.ArrayList;
import java.util.List;

public class lc78 {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public void dfs(int[] nums,int step){
        if(step>=nums.length){
            res.add((ArrayList<Integer> )temp.clone());
            return;
        }

        //取
//        temp.add(nums[step]);
//        dfs(nums,step+1);
//        temp.remove(temp.size()-1);
//
//        //不取
//        dfs(nums,step+1);

        for (int i = step; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i + 1);
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return res;
    }
}
