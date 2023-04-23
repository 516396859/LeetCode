import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc1387 {

    public int score(int num){
        if(num==1){
            return 0;
        }
        if(num%2==0){
            return score(num/2)+1;
        }else {
            return score(3*num+1)+1;
        }
    }

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });

        for (int i = lo; i <= hi; i++) {
            que.add(new int[]{i,score(i)});
        }

        for (int i = 0; i < k-1; i++) {
            que.poll();
        }
        return que.peek()[0];
    }

    @Test
    public void test(){
        lc1387 lc = new lc1387();
        int score = lc.score(3);
        System.out.println(score);
    }
}
