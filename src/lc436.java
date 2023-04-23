import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class lc436 {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        ArrayList<Integer> arr = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            map.put(left,i);
        }

        for (int i = 0; i < len; i++) {
            int right = intervals[i][1];
            if(map.keySet().contains(right)){
                arr.add(map.get(right));
            }else if(map.keySet().contains(right+1)){
                arr.add(map.get(right+1));
            }
            else {
                arr.add(-1);
            }
        }

        int length = arr.size();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    @Test
    public void test(){
        lc436 lc = new lc436();
        int[] ints = lc.findRightInterval(new int[][]{{4,5},{2,3},{1,2}});
        System.out.println(ints[0]+"  "+ints[1]);
    }
}
