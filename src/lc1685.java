import org.junit.Test;

public class lc1685 {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        //使用一个规律，即数组是递增的，即后一个数的和与前一个数的和之间的关系
        //关系是，假设第i+1个数比第i个数大k，则i+1之后的数会在sum(i)的基础上少 (n-i+1)*k
        //而i之前的数会在sum(i)的基础上多 (i-1)*k

        int n = nums.length;
        int[] res = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=(Math.abs(nums[i]-nums[0]));
        }
        res[0] = sum;

        for (int i = 1; i < n; i++) {
            int k = nums[i]-nums[i-1];
            int a = (i-1)*k;
            int b = (n-i-1)*k;
            res[i] = res[i-1]+a-b;
        }

        return res;
    }

    @Test
    public void test(){
        lc1685 lc = new lc1685();
        int[] i = lc.getSumAbsoluteDifferences(new int[]{1, 1, 1});
        System.out.println(i);
    }
}
