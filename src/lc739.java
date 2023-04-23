import java.util.ArrayDeque;

public class lc739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈，维护一个递减栈
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        int[][] temp = new int[temperatures.length][2];
        for (int i = 0; i < temperatures.length; i++) {
            temp[i][0] = i; //第一个记录下标
            temp[i][1] = temperatures[i]; //第二个记录下标对应的温度
        }

        stack.addLast(temp[0]);
        for (int i = 1; i < temp.length; i++) {
            int[] ct = temp[i]; //现在的温度
            while (!stack.isEmpty()){
                if(ct[1]>stack.getLast()[1]){
                    int[] last = stack.pollLast();
                    res[last[0]] = i-last[0];   //出栈：第一个比它大的下标-他自己的下标 就是第几天温度比他高
                }else {
                    stack.addLast(ct);
                    break;
                }
            }
            // 否则栈空就进栈
            stack.addLast(ct);
        }
        return res;
    }
}
