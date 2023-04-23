import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class lc901 {
    Stack<Integer> stack ;
    HashMap<Integer, Integer> map;
    public lc901(){
        stack = new Stack<>();
        map = new HashMap<>();
    }

    public int next(int price) {
        //维护单调递减栈
        if(stack.isEmpty() || stack.peek()>price){
            stack.push(price);
            return 1;
        }
        int count = 0;
        while (!stack.isEmpty() && stack.peek()<=price){
            if(map.containsKey(stack.peek())){
                count += map.get(stack.peek());
                map.remove(stack.peek());
            }
            stack.pop();
            count += 1;
        }
        stack.push(price);
        map.put(price,count);
        return count+1;
    }

    @Test
    public void test(){
        lc901 lc = new lc901();
        int a = lc.next(10);
        int b = lc.next(40);
        int c= lc.next(60);
        int d= lc.next(20);
        System.out.println(a+" "+b+" "+c+" "+d);
    }
}
