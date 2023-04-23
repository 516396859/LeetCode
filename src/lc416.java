import org.junit.Test;

import java.util.Arrays;

//public class lc416 {
//    public boolean canPartition(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        if(sum%2==1){
//            return false;
//        }else {
//            sum /= 2;
//        }
//
//        // dp[i][j] : 前面i个数能否选若干个和为j
//        boolean[][] dp = new boolean[nums.length][sum+1];
//        //重要的初始化，易错
//        for (int j = 0; j <= sum; j++) {
//            if(j==nums[0]){
//                dp[0][j] = true;
//            }
//        }
//
//        for (int i = 0; i<nums.length; i++) {
//            dp[i][0] = true;
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j <= sum; j++) {
//                if(j-nums[i]>=0){
//                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
//                }else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        return dp[nums.length-1][sum];
//    }
//
//    @Test
//    public void test(){
//        lc416 lc = new lc416();
//        boolean b = lc.canPartition(new int[]{1, 5, 10, 6});
//        System.out.println(b);
//    }
//}



public class lc416 {

    public boolean recurr(int[] nums,int i,int j){

        if(j<0){
            return false;
        }

        // 终止条件
        if(j==0){
            return true;
        }
        if(i==0){
            if(j==nums[i]){
                return true;
            }else {
                return false;
            }
        }
        return recurr(nums,i-1,j) || recurr(nums,i-1,j-nums[i]);
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2==1){
            return false;
        }else {
            sum /= 2;
        }
        return recurr(nums,nums.length-1,sum);
    }

    @Test
    public void test(){
        lc416 lc = new lc416();
        boolean b = lc.canPartition(new int[]{1, 2, 10, 6});
        System.out.println(b);
    }
}
