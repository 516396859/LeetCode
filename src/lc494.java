import org.junit.Test;

public class lc494 {
//    public int findTargetSumWays(int[] nums, int target) {
//        //很容易转为背包问题，背包问题的取不取换成+还是-
//        //dp[n][target] 表示前n个数组合得到target的种类数目，取决于n-1此的值与最后一个数的值
//        //dp[n][target] = dp[n-1][target-nums[n]]  +  dp[n-1][target+nums[n]]
//
//        int[][] dp = new int[nums.length][target+1];
//        //初始化
//        for (int j = 0; j <= target; j++) {
//            if(nums[0]==j){
//                dp[0][j]+=1;
//            }
//            if(-nums[0]==j){
//                dp[0][j]+=1;
//            }
//        }
//        //无法进行初始化
////        for (int i = 1; i < nums.length; i++) {
////            dp[i][0] = dp[i-1]
////        }
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j <= target; j++) {
//
//                dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]];
//            }
//        }
//
//
//    }

    public int dp(int[] nums, int i, int j) {
        if (i == 0 && nums[0] == 0 && j == 0) {
            return 2;
        }
        if (i == 0 && ((nums[0] == j) || (-nums[0] == j)) ) {
            return 1;
        }
        if (i==0){
            return 0;
        }
        return dp(nums,i-1,j-nums[i]) + dp(nums,i-1,j+nums[i]);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int dp = dp(nums, nums.length - 1, target);
        return dp;
    }
    @Test
    public void test(){
        lc494 lc = new lc494();
        int targetSumWays = lc.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}
