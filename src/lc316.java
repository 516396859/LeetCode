import org.junit.Test;

import java.util.ArrayDeque;

public class lc316 {
        public String removeDuplicateLetters(String s) {
            //使用单调栈保持字典序
            ArrayDeque<Character> stack = new ArrayDeque<Character>();
            int length = s.length();
            stack.addLast(s.charAt(0));
            StringBuffer res = new StringBuffer();

            for(int i=1;i<length;i++){

                int flag = 0;

                Character c = stack.getLast();
                String sub = s.substring(i,length);
                while (c>s.charAt(i) && !stack.contains(s.charAt(i)) && sub.contains(""+c) && !stack.isEmpty()){
                    //栈顶元素大于待检测字符且栈中没有该元素，且栈顶元素后续还有 且栈非空 则出栈
                    stack.pollLast();
                    if(!stack.isEmpty())
                        c = stack.getLast();
                    flag = 1;
                }

                if(flag==1){
                    // 出栈完成后，待检测字符入栈
                    stack.addLast(s.charAt(i));
                }

                if(!stack.contains(s.charAt(i))){  //c<s.charAt(i) &&
                    // 如果待检测字符小于c且栈中不包含它则直接进栈
                    stack.addLast(s.charAt(i));
                }

            }
            while(!stack.isEmpty()){
                Character c = stack.pollLast();
                res.append(c);
            }

            return res.reverse().toString();
        }

    @Test
    public void my_test() {
        lc316 lc = new lc316();
        String res = lc.removeDuplicateLetters("bcabc");
        System.out.println(res);
    }
}
