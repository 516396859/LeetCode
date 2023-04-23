import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc973 {
    public int[][] kClosest(int[][] points, int k) {

        ArrayList<int[]> arr = new ArrayList<>();

        PriorityQueue<int[]> deq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });

        for (int i = 0; i < points.length; i++) {
            deq.add(points[i]);
        }

        for (int i = 0; i < k; i++) {
            int[] point = deq.poll();
            arr.add(point);
        }

        int[][] res = new int[arr.size()][2];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
