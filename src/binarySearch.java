import org.junit.Test;

public class binarySearch {
    public int binarySearch_f1(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        //重点：start+1<end ，此时会少判断一次需要单独拿出来判断，
        //避免边界条件出现错误，这也是此模板的灵魂，精髓
        while (start+1<end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid]>target) {
                end = mid;   // 不用管要不要mid-1 或者 mid+1 ，全部写成 mid
            } else{
                start = mid;
            }
        }
        // 重点：精髓，因为循环中跳过了中间相邻两个元素的判断，因此需要在外面单独判断
        // 此时经过while循环，start 与 end 相邻，即 start+1==end
        if(nums[start]==target){
            return start;
        }
        if(nums[end]==target){
            return end;
        }
        return -1;
    }

    public int binarySearch_f2(int[] nums,int start , int end , int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }

        int middle = start + (end-start)/2;

        //边界条件的判断
        if(start+1==end){
            if(nums[start]==target){
                return start;
            }else if(nums[end]==target){
                return end;
            }else {
                return -1;
            }
        }

        if(nums[middle]==target){
            return middle;
        }
        if(nums[middle]<target){
            return binarySearch_f2(nums,middle,end,target);
        }else {
            return binarySearch_f2(nums,start,middle,target);
        }
    }


    public int binarySearch_first(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start+1<end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                end = mid;   // 当找到了一个并不能直接返回，而是将其作为右边界，包含关系
            } else if (nums[mid]>target) {
                end = mid;   // 不用管要不要mid-1 或者 mid+1 ，全部写成 mid
            } else{
                start = mid;
            }
        }


        //注意这两个边界点的判断顺序
        if(nums[start]==target){
            return start;
        }
        if(nums[end]==target){
            return end;
        }
        return -1;
    }


    public int binarySearch_last(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start+1<end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                start = mid;   // 当找到了一个并不能直接返回，而是将其作为左边界，包含关系
            } else if (nums[mid]>target) {
                end = mid;   // 不用管要不要mid-1 或者 mid+1 ，全部写成 mid
            } else{
                start = mid;
            }
        }

        //注意这两个边界点的判断顺序
        if(nums[end]==target){
            return end;
        }
        if(nums[start]==target){
            return start;
        }
        return -1;
    }


    @Test
    public void test(){
        binarySearch bs = new binarySearch();
        int[] arr = new int[]{1,3,3,4,5,5,5,7,8,9};
        int i = bs.binarySearch_last(arr,5);
        System.out.println(i);
    }

}
