//import java.util.ArrayList;
//
//public class lc2289 {
//
//    public int[] removeNums(int[] nums){
//        int len = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if(nums[i]>nums[i+1]){
//                nums[i+1] = -1;
//                len ++ ;
//            }
//        }
//
//        int[] res = new int[nums.length-len];
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]!=-1){
//                res[j++] = nums[i];
//            }
//        }
//        return res;
//    }
//    public int totalSteps(int[] nums) {
//        int org = nums.length;
//
//        while (true){
//            int[] res = removeNums(nums);
//            if(res.length==org){
//                return res;
//            }
//        }
//
//    }
//}
