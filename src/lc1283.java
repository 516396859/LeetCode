import org.junit.Test;

public class lc1283 {

    public int summ(int[] nums,int n){
        int sum = 0;
        for(int a:nums){
            sum+=(int)Math.ceil((double)a/n);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int max = 0;
        for(int c:nums){
            max= Math.max(max,c);
        }

        int left = 1;
        int right =max;

        while (left+1<right){
            int mid = left+(right-left)/2;
            if(summ(nums,mid)>threshold){
                left = mid;
            } else {
                right = mid;
            }
        }
        if(summ(nums,left)<=threshold){
            return left;
        }

        if(summ(nums,right)<=threshold){
            return right;
        }

        return 0;
    }

    @Test
    public void test(){
        lc1283 lc = new lc1283();
        int i = lc.smallestDivisor(new int[]{44,22,33,11,1},5);
        System.out.println(i);

        int x= -122 ;
        StringBuffer s = new StringBuffer(x + "");
        StringBuffer sb = new StringBuffer(x + "");
        StringBuffer reverse = sb.reverse();

        System.out.println(reverse.toString());

        System.out.println(s.toString().equals(reverse.toString()));

    }
}
