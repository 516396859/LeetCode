import org.junit.Test;

public class lc34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int first = -1;
        int last = -1;

        if(nums==null || nums.length==0){
            return new int[]{first,last};
        }

        // 寻找第一次出现的位置
        while(left+1<right){
            int middle = left + (right-left)/2;
            if(nums[middle]==target){
                right = middle;
            }else if(nums[middle]>target){
                right = middle;
            }else {
                left = middle;
            }
        }

        if(nums[left]==target){
            first = left;
        }else if(nums[right]==target){
            first = right;
        }

        if(first!=-1){
            for (int i = first; i < nums.length ; i++) {
                if(nums[i]==target){
                    last = i;
                }else {
                    break;
                }
            }
        }
        return new int[]{first,last};
    }

    @Test
    public void test(){
        lc34 lc = new lc34();
        int[] ints = lc.searchRange(new int[]{2,2}, 2);
        System.out.println(ints[0]+"  "+ints[1]);
    }
}
