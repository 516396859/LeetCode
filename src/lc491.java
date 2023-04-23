import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc491 {

    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();

    public void dfs(int[] nums,int startIndex){
        if(temp.size()>=2){
            res.add((ArrayList<Integer> )temp.clone());
        }

        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i + 1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums,0);
        Arrays.sort(nums);
        return res;
    }
}
