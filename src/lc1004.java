import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class lc1004 {


    public int zeroCount(int[] nums , int start,int end){
        int count = 0;
        for (int i = start; i <= end; i++) {
            if(nums[i]==0){
                count++;
            }
        }
        return count;
    }

    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            if(nums[right]==0){
                count++;
            }

            while(left<nums.length && count>k){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            if(left<nums.length){
                //满足条件
                res = Math.max(res,right-left+1);
            }
        }
        return res;
    }

    @Test
    public void test(){
        lc1004 lc = new lc1004();
        int count = lc.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2);
        System.out.println(count);
    }
}
