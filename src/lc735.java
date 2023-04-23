import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class lc735 {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int a : asteroids){
            if(stack.isEmpty() || (stack.getLast()<0 && a>0) || stack.getLast()*a>0){
                // 如果栈为空，或者<-- -->这样的方向，或者同向，直接加进来，因为这些都喷不到
                stack.addLast(a);
            }else {
                while(!stack.isEmpty() && (stack.getLast()>0 && a<0) && Math.abs(stack.getLast())<Math.abs(a)){
                    stack.pollLast();
                }

                //因为空结束，同向结束
                if(stack.isEmpty()||stack.getLast()*a>0){
                    stack.addLast(a);
                }
                //因为质量相等结束，条件要求会碰才能消除
                else if(Math.abs(stack.getLast())==Math.abs(a) && (stack.getLast()>0 && a<0)){
                    stack.pollLast();
                }
            }
        }
        int[] res = new int[stack.size()];
        int i=0;
        while (!stack.isEmpty()){
            res[i] = stack.pollFirst();
            i++;
        }
        return res;
    }

    @Test
    public void test(){
        lc735 lc = new lc735();
        int[] res = lc.asteroidCollision(new int[]{-2,-1,1,2});
    }
}
