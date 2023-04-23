import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 下一个更大，单调递减对列
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
//        stack.push(nums2[0]);
        for (int i = 0; i < nums2.length; i++) {
            if(stack.isEmpty()||stack.peek()>=nums2[i]){
                stack.push(nums2[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek()<nums2[i]){
                map.put(stack.peek(),nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])){
                res[i] = map.get(nums1[i]);
            }else {
                res[i] = -1;
            }
        }
        return res;
    }

    @Test
    public void test(){
        lc496 lc = new lc496();
        int[] ints = lc.nextGreaterElement(new int[]{2,4}, new int[]{1, 2,3,4});
        for(int a : ints){
            System.out.println(a);
        }
    }
}
