public class lc53 {

    int max = Integer.MIN_VALUE;
    public int maxSub(int[] num , int i){
        if(i<0){
            return 0;
        }

        int b = num[i];
        int a = maxSub(num,i-1) + num[i] ;

        int cur = Math.max(a,b);
        max = Math.max(max,cur);
        return cur;
    }


    public int maxSubArray(int[] nums) {
        // 表示结尾为length-1的数组的连续最大值，下一个数 要么取，要么重新开始
        maxSub(nums,nums.length-1);
        return max;
    }
}
