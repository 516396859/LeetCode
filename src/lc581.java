import org.junit.Test;

import java.util.Stack;

public class lc581 {
    public int findUnsortedSubarray(int[] nums) {
        //从左往右维护递增栈，记录出栈元素的下标，取最小的下标
        //从右往左维护递减栈，记录出栈元素的下标，取最大的下标
        Stack<int[]> sta = new Stack<>();
        int left = nums.length-1;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            if(sta.isEmpty() || sta.peek()[1]<=nums[i]){
                sta.push(new int[]{i,nums[i]});
                continue;
            }
            while (!sta.isEmpty() && sta.peek()[1]>nums[i]){
                left = Math.min(left,sta.peek()[0]);
                sta.pop();
            }
        }

        sta.clear();
        for (int i = nums.length-1; i >=0; i--) {
            if(sta.isEmpty() || sta.peek()[1]>=nums[i]){
                sta.push(new int[]{i,nums[i]});
                continue;
            }
            while (!sta.isEmpty() && sta.peek()[1]<nums[i]){
                right = Math.max(right,sta.peek()[0]);
                sta.pop();
            }
        }

        System.out.println(left+" "+right);
        if(left == nums.length-1 && right == 0){
            return 0;
        }else{
            return right-left-1;
        }
    }

    @Test
    public void test(){
        lc581 lc = new lc581();
        int unsortedSubarray = lc.findUnsortedSubarray(new int[]{1,2,3,3,3});
        System.out.println(unsortedSubarray);
    }
}
