//import org.junit.Test;
//
//public class off011 {
//    public int findMaxLength(int[] nums) {
//        //将0改为-1之后用前缀和
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]==0){
//                nums[i] = -1;
//            }
//        }
//
//        int[] B = new int[nums.length];
//        B[0] = nums[0];
//        if(B[0]==0){
//            count+=1;
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            B[i] = B[i-1]+nums[i];
//            if(B[i]==0){
//                count += 1;
//            }
//        }
//
//        for (int i = 0; i < B.length; i++) {
//        }
//        if(count==1){
//            return idx_max+1;
//        }
//        return Math.max(idx_max-idx_min+1,idx_max);
//    }
//    @Test
//    public void test(){
//        off011 of = new off011();
//        int maxLength = of.findMaxLength(new int[]{0,0,1,0,0,0,1,1});
//        System.out.println(maxLength);
//    }
//}
