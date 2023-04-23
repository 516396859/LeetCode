public class lc167 {
    public int[] twoSum(int[] numbers, int target) {
        //因此此题数组有序，用双指针来解
        int left = 0;
        int right = numbers.length - 1;
        while (left + 1 < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            }else {
                return new int[]{left+1,right+1};
            }
        }

        return new int[]{left+1,right+1};
    }
}
