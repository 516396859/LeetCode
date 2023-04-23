public class lc2574 {
    public int[] leftRigthDifference(int[] nums) {
        //前缀和和后缀和
        int[] answer =  new int[nums.length];
        int[] B = new int[nums.length];
        B[0] = nums[0];
        int[] A = new int[nums.length];
        A[nums.length-1] = nums[nums.length-1];

        for (int i = 1; i < nums.length; i++) {
            B[i] = B[i-1]+nums[i];
        }

        for (int i = nums.length-2; i >=0; i--) {
            A[i] = A[i+1]+nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int left = B[i]-nums[i];
            int right = A[i] - nums[i];
            answer[i] = Math.abs(left-right);
        }
        return answer;
    }
}
