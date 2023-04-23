public class offer53 {public int search(int[] nums, int target) {

    if(nums==null||nums.length==0){
        return 0;
    }

    //二分查找
    int left = 0;
    int right = nums.length-1;

    while(left+1<right){
        int mid = left + (right-left)/2;
        if(nums[mid]>=target){
            right = mid;
        }else {
            left = mid;
        }
    }

    int start = 0;
    if(nums[left]==target){
        start = left;
    }else if (nums[right]==target){
        start = right;
    }else {
        start = 0;
    }

    left = 0;
    right = nums.length-1;

    while(left+1<right){
        int mid = left + (right-left)/2;
        if(nums[mid]<=target){
            left = mid;
        }else {
            right = mid;
        }
    }

    int end = 0;

    if(nums[right]==target){
        end = right;
    } else if (nums[left]==target) {
        end = left;
    }else {
        end = 1;
    }
    return end-start+1;
}

}
