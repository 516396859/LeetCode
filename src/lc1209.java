import org.junit.Test;

import java.util.Stack;

public class lc1209 {

    public Stack stackOk(Character c,Stack stack,int k){
        Stack<Character> sta = (Stack<Character>)stack.clone();
        for (int i = 0; i < k - 1; i++) {
            Character pop = sta.pop();
            if(c!=pop){
                return stack;
            }
        }
        return sta;
    }

    public String removeDuplicates(String s, int k) {
        //栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.size()<(k-1)){
                stack.add(s.charAt(i));
                continue;
            }
            //判断前k-1个字符是否都等于当前入栈字符
            Stack newstack = stackOk(s.charAt(i), stack, k);
            if(newstack!=stack){
                stack = newstack;
            }else {
                stack.add(s.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        lc1209 lc = new lc1209();
        String res = lc.removeDuplicates("deeedbbcccbdaa", 3);
        System.out.println(res);
    }
}
