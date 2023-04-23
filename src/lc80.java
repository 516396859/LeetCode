import org.junit.Test;

public class lc80 {

    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                count++;
                if(count>2){
                    nums[i] = -1;
                }
            }else{
                count = 1;
            }
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==-1){

            }
        }

        System.out.println(count);
        return count;
    }



    @Test
    public void test(){
        lc80 lc = new lc80();
        lc.removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}
