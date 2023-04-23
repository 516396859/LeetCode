public class offer53_2 {
    public int missingNumber(int[] nums) {
        //二分法
        if(nums==null || nums.length==0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        while(left+1<right){
            int mid = left + (right-left)/2;
            if(mid==nums[mid]){
                right = mid;
            }else {
                left = mid;
            }
        }
        if(nums[left]!=left){
            return left;
        }
        if(nums[right]!=right) {
            return right;
        }
        return right+1;
    }
}
