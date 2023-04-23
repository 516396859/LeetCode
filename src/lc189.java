import org.junit.Test;

public class lc189 {
    public void rotate(int[] nums, int k) {
        int left=0;
        int n = nums.length;
        left = (left+k)%n;

        int count = n-1;
        int temp = nums[left];
        while (count>0){
            int p = ((n+left-(k%n)))%n;
            nums[left] = nums[p];
            left = p;
            count--;
        }

        nums[left] = temp;

    }
    @Test
    public void test(){
        lc189 lc = new lc189();
        lc.rotate(new int[]{1,2,3,4},3);
    }
}
