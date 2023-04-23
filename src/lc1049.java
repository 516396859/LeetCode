import org.junit.Test;

import java.util.Arrays;

public class lc1049 {
    public int lastStoneWeightII(int[] stones) {
        //dp[n][j] 表示前n个石头能够得到的最大重量，j<=sum/2,前n石头的状态取决于n-1的最大值对n取或者不取
        // dp[n][j] = max(dp[n-1][j],dp[n-1][j-stones[n]]+stones[i])
        int all = Arrays.stream(stones).sum();
        int sum = all/2;
        int[][] dp = new int[stones.length][sum+1];
        //进行初始化，很重要
        for (int i = 0; i < stones.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <=sum; j++) {
            if(stones[0]<=j){
                dp[0][j] = stones[0];
            }else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if(j>=stones[i]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return all-dp[stones.length-1][sum]*2;
    }

    @Test
    public  void test(){
        lc1049 lc = new lc1049();
        int i = lc.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println(i);
    }
}
