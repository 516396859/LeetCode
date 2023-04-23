import org.junit.Test;

import java.util.HashMap;

public class off010 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] B = new int[nums.length];
        B[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            B[i] = B[i-1]+nums[i];
        }
        //此时将题目转变成，从数组B中找两个下标 B[i]-B[j-1]==k ，多少组i，j就是答案
        //使用两数之和的那个解法,B[j-1] = k - B[i]
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < B.length; i++) {
            if(map.containsKey(B[i]-k)){
                res += map.get(B[i]-k);
            }
            map.put(B[i], map.getOrDefault(B[i],0)+1);
        }
        return res;
    }

    @Test
    public void test(){
        off010 of = new off010();
        int i = of.subarraySum(new int[]{-1, -1, 1,}, 0);
        System.out.println(i);
    }
}
