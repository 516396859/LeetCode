import java.util.Comparator;
import java.util.PriorityQueue;

public class lc215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> deq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int a:nums){
            deq.add(a);
        }

        for (int i = 0; i < k-1; i++) {
            deq.poll();
        }
        return deq.peek();
    }
}
