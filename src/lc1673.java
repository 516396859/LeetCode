import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class lc1673 {
    public int maxWidthOfVerticalArea(int[][] points) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        for (int i = 0; i < points.length; i++) {
//            arr.add(points[i][0]);
//        }
//
//        Arrarr.sort();

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int res = 0;

        for (int i = 0; i < points.length-1; i++) {
            res = Math.max(res,(points[i+1][0]-points[i][0]));
        }
        return res;
    }
}
