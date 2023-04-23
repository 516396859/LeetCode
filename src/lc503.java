import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class lc503 {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] nums2 = new int[nums.length*2];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = nums[i%nums.length];
        }
        for (int i = 0; i < nums2.length; i++) {
            if(stack.isEmpty() || nums2[stack.peek()]>=nums2[i]){
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && nums2[stack.peek()]<nums2[i]){
                if(!map.containsKey(stack.peek())){
                    map.put(stack.peek(),nums2[i]);
                }
                stack.pop();
            }
            stack.push(i);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(i)){
                res[i] = map.get(i);
            }else {
                res[i] = -1;
            }
        }
        return res;
    }

    @Test
    public void test(){
        lc503 lc = new lc503();
        int[] ints = lc.nextGreaterElements(new int[]{1,11,1,120});
        for (int a: ints){
            System.out.println(a);
        }
    }
}
