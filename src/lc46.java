import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc46 {

    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    int[] visit;

    public void dfs(int[] nums,int startIndex){
        if(temp.size()==nums.length){
            res.add((ArrayList<Integer> )temp.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visit[i]==0){
                visit[i] = 1;
                temp.add(nums[i]);
                dfs(nums, i + 1);
                temp.remove(temp.size()-1);
                visit[i] = 0;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        visit = new int[nums.length];
        dfs(nums,0);
        return res;
    }

    @Test
    public void test(){
        lc46 lc = new lc46();
        List<List<Integer>> permute = lc.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

}
