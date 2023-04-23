import org.junit.Test;

public class lc33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left+1<right){
            int middle = left + (right-left)/2;
            if(nums[middle]>nums[left]){ //左侧有序
                if(target>=nums[left] && target<=nums[middle]){
                    right = middle;
                }else{
                    left = middle;
                }
            }

            if(nums[middle]<nums[right]){ //右侧有序
                if(target>=nums[middle] && target<=nums[right]){
                    left = middle;
                }else{
                    right = middle;
                }
            }
        }

        if(nums[left]==target){
            return left;
        }

        if(nums[right]==target){
            return right;
        }
        return -1;
    }

    @Test
    public void test(){
        lc33 lc = new lc33();
        int search = lc.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(search);
    }
}
