import org.junit.Test;

import java.util.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class spring_03 {
    int n;
    double[][] rec; //0下标记录重叠计数
    List newRec;
    double res = 1;
    public int fieldOfGreatestBlessing(int[][] forceField) {
        int n = forceField.length;
        rec = new double[n][5];
        newRec = new ArrayList();

        for (int i = 0; i < n; i++) {
            int x = forceField[i][0];
            int y = forceField[i][1];
            int d = forceField[i][2];
            rec[i][1] = x-(d/2.0); //左下角横坐标
            rec[i][2] = y-(d/2.0); //左下角的纵坐标
            rec[i][3] = x+(d/2.0); //右上角的横坐标
            rec[i][4] = y+(d/2.0); //右上角的纵坐标
        }
        for (int k = 0; k < n; k++) {
            rec[k][0] = 1;
        }
        solve();
        return (int)res;
    }
    void solve() {
        for (int i = 1; i < n; i++) {
            double[] cover;
            for (int j = 0, len = newRec.size(); j < len; ++j) {
                if((cover = getCover((double[])newRec.get(j), rec[i])) != null) {
                    newRec.add(cover);
                }
            }
            for (int j = 0; j < i; j++) {
                if((cover = getCover(rec[j], rec[i])) != null)
                    newRec.add(cover);
            }
        }
    }
    double[] getCover(double[] a, double[] b) {
        double x1 = Math.max(a[1], b[1]);
        double y1 = Math.max(a[2], b[2]);
        double x2 = Math.min(a[3], b[3]);
        double y2 = Math.min(a[4], b[4]);
        if(x1 < x2 && y1 < y2) {
            res = Math.max(res, a[0] + b[0]);
            return new double[]{a[0] + b[0], x1, y1, x2, y2};
        }
        return null;
    }

    @Test
    public void test(){
        int i = fieldOfGreatestBlessing(new int[][]{{4, 4, 6}, {7, 5, 3}, {1, 6, 2}, {5, 6, 3}});
        System.out.println(i);
    }
}
