import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SSS {
    int n;
    List<List<Integer>> res;
    int[] visit;
    int[] permu;

    public void dfs(int[] nums,int step){
        if(step==n){ //存了10个数达到结束条件
            List<Integer> arr = new ArrayList<>();
            for(int a:permu){
                arr.add(a);
            }
            res.add(arr);
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visit[i]==0){
                permu[step] = nums[i];
                visit[i] = 1;
                dfs(nums,step+1);
                visit[i] = 0;  //记得回溯
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        visit = new int[n];
        permu = new int[n]; //存一个结果
        dfs(nums,0); //0表示permu中存了0个数
        System.out.println(res);
        return res;
    }

    @Test
    public void test(){
        SSS s = new SSS();
        s.permute(new int[]{1,2,3});
    }


}