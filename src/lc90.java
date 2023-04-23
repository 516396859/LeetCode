import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc90 {

    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();

    public void dfs(int[] nums,int startIndex){
        res.add((ArrayList<Integer> )temp.clone());
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if(set.contains(nums[i]) ||(temp.size()>0&&nums[i]<temp.get(temp.size()-1)) ){
                continue;
            }
            set.add(nums[i]);
            temp.add(nums[i]);
            dfs(nums, i + 1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(nums,0);
        Arrays.sort(nums);
        return res;
    }
}
