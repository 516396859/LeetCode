import java.util.Stack;

public class offer09 {
    Stack<Integer> input;
    Stack<Integer> output;
    public offer09() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void appendTail(int value) {
        input.add(value);
    }

    public int deleteHead() {
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.add(input.pop());
            }
        }
        return output.isEmpty()? -1 : output.pop();
    }
}
