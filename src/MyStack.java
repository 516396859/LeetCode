import java.util.ArrayDeque;

public class MyStack {
    ArrayDeque deque1;
    ArrayDeque deque2;
    public MyStack() {
        deque1 = new ArrayDeque<Integer>();
        deque2 = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        if(!deque1.isEmpty()){
            deque1.addLast(x);
        }else if(!deque2.isEmpty()){
            deque2.addLast(x);
        }else {
            deque1.addLast(x);
        }
    }

    public int pop() {
        ArrayDeque<Integer> deque = null;
        ArrayDeque<Integer> helpdeq = null;
        if(!deque1.isEmpty()){
            deque = deque1;
            helpdeq = deque2;
        }

        if(!deque2.isEmpty()){
            deque = deque2;
            helpdeq = deque1;
        }

        while (deque.size()>1){
            Integer value = deque.removeFirst();
            helpdeq.addLast(value);
        }
        // 当deque.size()==1
        Integer p = deque.removeFirst();
        return p;
    }

    public int top() {
        int pop = pop();
        push(pop);
        return pop;
    }

    public boolean empty() {
        if(deque2.isEmpty() && deque1.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
