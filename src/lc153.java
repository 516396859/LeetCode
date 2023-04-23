import org.junit.Test;

public class lc153 {
    public int findMin(int[] nums) {
        int left=0;
        int right = nums.length-1;

        if(nums[left]<nums[right]){
            return nums[left];
        }

        while(left+1<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[left]){
                //左边有序,往右边找
                left = mid;

            } else if (nums[mid] < nums[right]) {
                //右边有序，往左边找
                right = mid;
            }
        }

        return Math.min(nums[left],nums[right]);
    }

    @Test
    public void test(){
        lc153 lc = new lc153();
        int res = lc.findMin(new int[]{4,5,6,7});
        System.out.println(res);
    }
}
