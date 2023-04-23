import org.junit.Test;

import java.util.*;
public class spring_033 {
    public int fieldOfGreatestBlessing(int[][] forceField) {
        int n = forceField.length;
        double[][] arr = new double[n][4];
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = forceField[i][0];
            int y = forceField[i][1];
            int d = forceField[i][2];
            arr[i][0] = x-(d/2.0); //左下角横坐标
            arr[i][1] = y-(d/2.0); //左下角的纵坐标
            arr[i][2] = x+(d/2.0); //右上角的横坐标
            arr[i][3] = y+(d/2.0); //右上角的纵坐标

            xList.add(arr[i][0]);
            xList.add(arr[i][2]);
            yList.add(arr[i][1]);
            yList.add(arr[i][3]);
        }

        int ret = 0;
        for (double x : xList) {
            for (double y : yList) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (x >= arr[i][0] && x <= arr[i][2] && y >= arr[i][1] && y <= arr[i][3]) {
                        cnt++;
                    }
                }
                if (cnt > ret) {
                    ret = cnt;
                }
            }
        }
        return ret;
    }
    @Test
    public void test(){
        int i = fieldOfGreatestBlessing(new int[][]{{4, 4, 6}, {7, 5, 3}, {1, 6, 2}, {5, 6, 3}});
        System.out.println(i);
    }

}
