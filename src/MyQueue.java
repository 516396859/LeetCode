import java.util.ArrayDeque;

public class MyQueue {
    ArrayDeque<Integer> stack_in;
    ArrayDeque<Integer> stack_out;
    public MyQueue() {
        stack_in = new ArrayDeque<>();
        stack_out = new ArrayDeque<>();
    }

    public void push(int x) {
        stack_in.addLast(x);
    }

    public int pop() {
        // 如果输出栈还有元素，先用出栈
        if(!stack_out.isEmpty()){
            Integer p = stack_out.removeLast();
            return p;
        }
        //else 否则
        while (!stack_in.isEmpty()){
            Integer last = stack_in.removeLast();
            stack_out.addLast(last);
        }
        Integer p = stack_out.removeLast();
        return p;
    }

    public int peek() {
        // 如果输出栈还有元素，先用出栈
        if(!stack_out.isEmpty()){
            Integer p = stack_out.getLast();
            return p;
        }
        //else 否则
        while (!stack_in.isEmpty()){
            Integer last = stack_in.removeLast();
            stack_out.addLast(last);
        }
        Integer p = stack_out.getLast();
        return p;
    }

    public boolean empty() {
        if(stack_out.isEmpty() && stack_in.isEmpty()){
            return true;
        }
        return false;
    }
}
