import org.junit.Test;

import java.util.ArrayList;

public class que26 {
    public int removeDuplicates(int[] nums) {
        //nums升序，所以，双指针
        final int flag = -99999;
        int count = 0;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if(nums[left]==nums[right]){
                nums[right]=flag;
                count++;
            }else {
                left = right;
            }
        }

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=flag){
                nums[idx] = nums[i];
                idx++;
            }
        }
        return nums.length-count;
    }

    @Test
    public void test(){
        int i = removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 5});
        System.out.println(i);
    }
}
