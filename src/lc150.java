import org.junit.Test;

import java.util.ArrayDeque;

public class lc150 {

    public boolean isNumber(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return false;
        }else {
            return true;
        }
    }

    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(isNumber(s)){
                int value = Integer.parseInt(s);
                stack.addLast(value);
            }else {
                if(stack.size()>=2){
                    int v2 = stack.removeLast();
                    int v1 = stack.removeLast();
                    switch (s){
                        case "+":{
                            stack.addLast(v1+v2);
                            break;
                        }
                        case "-":{
                            stack.addLast(v1-v2);
                            break;
                        }
                        case "*":{
                            stack.addLast(v1*v2);
                            break;
                        }
                        case "/":{
                            stack.addLast(v1/v2);
                            break;
                        }
                    }
                }
            }
        }
        return stack.getLast();
    }

    @Test
    public void test(){
        lc150 lc = new lc150();
        int i = lc.evalRPN(new String[]{"2","1","+","3","*"});
        System.out.println(i);
    }
}
