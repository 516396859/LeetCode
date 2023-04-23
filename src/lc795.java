import org.junit.Test;

public class lc795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[j], max);
                if (max >= left && max <= right) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        lc795 lc = new lc795();
        int i = lc.numSubarrayBoundedMax(new int[]{2,1,4,3}, 2,4);
        System.out.println(i);
    }
}