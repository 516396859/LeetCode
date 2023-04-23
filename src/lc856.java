import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class lc856 {
    public int scoreOfParentheses(String s) {
        if(s.equals("()")){
            return 1;
        }
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        stack.addLast(s.charAt(0));
        int idx = 0;
        for (int i = 1; i < s.length(); i++) {
            if(stack.isEmpty()){
                idx = i;
                break;
            }
            if(s.charAt(i)==')'&& stack.getLast()=='('){
                stack.pollLast();
            }else {
                stack.addLast(s.charAt(i));
            }
        }

        if(idx!=0){
            //分左右  AB型
            return scoreOfParentheses(s.substring(0,idx))+scoreOfParentheses(s.substring(idx,s.length()));
        }else {
            //内嵌型
            return 2*scoreOfParentheses(s.substring(1,s.length()-1));
        }
    }

    @Test
    public void test(){
        lc856 lc = new lc856();
        int i = lc.scoreOfParentheses("(()(()))");
        System.out.println(i);
    }
}
