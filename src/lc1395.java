import java.util.ArrayList;
import java.util.Arrays;

public class lc1395 {
    int count = 0;
    ArrayList<Integer> temp = new ArrayList<>();
    public void dfs(int[] rating,int startIndex){
        if(temp.size()==3){
            if((temp.get(0)>temp.get(1) && temp.get(1)>temp.get(2))||(temp.get(0)<temp.get(1) && temp.get(1)<temp.get(2))){
                count++;
                System.out.println(temp);
                return;
            }
            return;
        }

        for (int i = startIndex; i <rating.length ; i++) {
            temp.add(rating[i]);
            dfs(rating,startIndex+1);
            temp.remove(temp.size()-1);
        }
    }

    //dp[i]记录的是第i个数之前比其值小的数的个数；
    public int numTeams(int[] rating) {
        // 暴力回溯 复杂度：n选3，n^3
        dfs(rating,0);
        return count;
    }
}
