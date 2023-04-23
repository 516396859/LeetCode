import java.util.ArrayList;
import java.util.Stack;

public class lc1019 {
    public int[] nextLargerNodes(ListNode head) {
        int[] res = new int[10001];
        Stack<int[]> sta = new Stack<>();
        ListNode p = head;
        int i=0;
        while (p!=null){
            int value = p.val;
            int idx = i;
            p = p.next;
            i ++;

            while (!sta.isEmpty()){
                int[] peek = sta.peek();
                if(value>peek[0]){
                    int[] pop = sta.pop();
                    res[pop[1]]=value;
                }else {
                    sta.add(new int[]{value,idx});
                    break;
                }
            }

            if(sta.isEmpty()){
                sta.add(new int[]{value,idx});
            }

        }
        int[] result = new int[i];
        for (int j = 0; j < i; j++) {
            result[j] = res[j];
        }
        return result;
    }
}
