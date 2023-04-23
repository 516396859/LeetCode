public class lc162 {
    public int findPeakElement(int[] nums) {
        //此题有两点第一边界是负无穷，因此，只要某一边在爬坡就一定会有山峰，因为就算一致上升，那么到了边界就是悬崖，即最后一个元素是山峰
        //因此，这道题的二分技巧是丢弃下降的一半，寻找上升的一半

        int left = 0;
        int right = nums.length;

        while (left+1<right){
            int middle = left+(right-left)/2;
            if(nums[middle]<nums[middle+1]){
                left = middle;
            }else{
                right = middle;
            }
        }

        if(nums[left]>nums[right]){
            return left;
        }else {
            return right;
        }
    }
}
