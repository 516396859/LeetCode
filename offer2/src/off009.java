import org.junit.Test;

public class off009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long sum = nums[0];
        int count = 0;
        while (left<=right && left<nums.length){
            if(sum<k){
                count++;
                right++;
                if(right<nums.length) sum *= nums[right];
                else left++;
            }else {
                sum /= nums[left];
                left++;
            }
            if(left==right&&sum>=k){
                left++;
                right++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        off009 off = new off009();
        int i = off.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        System.out.println(i);
    }
}
