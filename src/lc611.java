import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class lc611 {


    public int last_target(int[] nums ,int start, int end , int target){


        //从nums的start到end中寻找最后一个满足target的下标
        while(start+1<end){
            int mid = (start+end)/2;
            if(nums[mid]<target){
                start = mid;
            }else {
                end = mid;
            }
        }

        if(end<nums.length && nums[end]<target){
            return end;
        }


        if(start<nums.length && nums[start]<target){
            return start;
        }

        return -1;
    }


    public int triangleNumber(int[] nums) {
        //解法：两短边之和大于第三边，先排序，再查找
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                // i j 指向的是两个短边,从后面的数中搜索第一个满足条件的下标
                int fdx = last_target(nums,j+1,nums.length-1,nums[i]+nums[j]);
                if(fdx!=-1){
                    count += (fdx-j);
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        lc611 lc = new lc611();
        int count = lc.triangleNumber(new int[]{2,3,4,4});
        System.out.println(count);
    }
}
