import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minsta;
    public MinStack() {
        stack = new Stack<>();
        minsta = new Stack<>();
    }

    public void push(int val) {
        if(minsta.isEmpty()){
            minsta.push(val);
        }else {
            minsta.push(Math.min(minsta.peek(),val));
        }
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        minsta.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minsta.peek();
    }
}
