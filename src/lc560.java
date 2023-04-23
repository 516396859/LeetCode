import org.junit.Test;

import java.util.Arrays;

public class lc560 {
    public int subarraySum(int[] nums, int k) {

        Arrays.sort(nums);

        int[] B = new int[nums.length];
        B[0] = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            B[i] = B[i-1]+nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                // 求i到j的前缀和，包括i和j
                int sum = B[j]-B[i]+nums[i];
                if(sum==k){
                    count++;
                }

                if(sum>k){
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        lc560 lc = new lc560();
        int i = lc.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(i);
    }
}
