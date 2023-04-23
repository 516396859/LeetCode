import org.junit.Test;

import java.util.HashMap;

public class lc525 {

//    public int findMaxLength(int[] nums) {
//        int[] B = new int[nums.length];
//        B[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            B[i] = B[i-1]+nums[i];
//        }
//
//        int res = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                int sum = B[j]-B[i]+nums[i];
//                if((j-i+1)==sum*2 && sum>res){
//                    res = sum;
//                }
//            }
//        }
//        return res;
//    }

    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                nums[i] = -1;
            }
        }
        int[] B = new int[nums.length];
        B[0] = nums[0];
        map.put(B[0],0);
        int maxx = 0;
        for (int i = 1; i < nums.length; i++) {
            B[i] = B[i - 1] + nums[i];
            if(!map.containsKey(B[i])){
                //只需要存第一个出现的值即可，因为求最长的，所以一定是第一个
                map.put(B[i],i);
            }else {
                //如果前面出现过
                int value = (i-map.get(B[i])-1);
                maxx = Math.max(value,maxx);
            }

            if(B[i]==0){
                maxx = Math.max(i+1,maxx);
            }

        }
        return maxx;
    }


    @Test
    public void test(){
        lc525 lc = new lc525();
        int i = lc.findMaxLength(new int[]{0, 1, 1});
        System.out.println(i);
    }
}
