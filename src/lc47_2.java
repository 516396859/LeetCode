import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc47_2 {

    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    int[] visit;
    public void dfs(int[] nums,int startIndex){
        if(temp.size()==nums.length){
            res.add((ArrayList<Integer> )temp.clone());
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(visit[i]==0 && !set.contains(nums[i])){
                set.add(nums[i]);
                visit[i] = 1;
                temp.add(nums[i]);
                dfs(nums, i + 1);
                temp.remove(temp.size()-1);
                visit[i] = 0;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        visit = new int[nums.length];
        dfs(nums,0);
        return res;
    }

    @Test
    public void test(){
        lc47_2 lc = new lc47_2();
        List<List<Integer>> permute = lc.permuteUnique(new int[]{1, 1, 2});
        System.out.println(permute);
    }
}
