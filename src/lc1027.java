import org.junit.Test;

import java.util.ArrayList;

public class lc1027 {
//    ArrayList<Integer> seq = new ArrayList<>();
//    int max = Integer.MIN_VALUE;
//    int count = 0;
//    public void longestSeq(int[] nums,int startIndex){
////        if(startIndex==nums.length){
////            max = Math.max(max,seq.size());
////            return;
////        }
//        // 上面这样写是错的，因为isValid是判断，并不能最后一个放行
//        max = Math.max(max,seq.size());
//        for (int i = startIndex; i < nums.length; i++) {
//            System.out.println(seq);
//            if(isValid(nums[i])){
//                seq.add(nums[i]);
//                longestSeq(nums,i+1);
//                seq.remove(seq.size()-1);
//            }
//        }
//    }
//
//    public boolean isValid(int num){
//        if(seq.size()<=1){
//            return true;
//        }else {
//            Integer last1 = seq.get(seq.size() - 1);
//            Integer last2 = seq.get(seq.size() - 2);
//            if((num-last1)==(last1-last2)){
//                return true;
//            }else {
//                return false;
//            }
//        }
//    }
//
//    public int longestArithSeqLength(int[] nums) {
//        //回溯，记录走过的子序列
//        longestSeq(nums,0);
//        return max;
//    }


    public void longestSeq(int[] nums,int startIndex){
        // dp[i][j] 表示前i个数，公差为j的最长子序列
        // dp[i][j] = dp[i-1][j] or dp[i-1][j]+1
        // 234



    }

    @Test
    public void test(){
//        longestArithSeqLength(new int[]{0,1,3,5,8},0);
    }
}
