import org.junit.Test;

public class lc27 {
    //双指针
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                count++;
                continue;
            }
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[j]!=val){
                    //找到了
                    nums[i] = nums[j];
                    nums[j] = val;
                    count++;
                    break;
                }
            }
        }
        return count;
    }


    @Test
    public void test(){
        lc27 lc = new lc27();
        int i = lc.removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println(i);
    }
}
