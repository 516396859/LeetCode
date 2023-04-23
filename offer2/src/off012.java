import org.junit.Test;

import java.util.Arrays;

public class off012 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(res*2+nums[i]==sum){
                return i;
            }
            res += nums[i];
        }
        return -1;
    }

    @Test
    public void test(){
        int i = pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(i);
    }
}
