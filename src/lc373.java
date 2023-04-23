import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class lc373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        //解法，第一个数组每个数来一次比较，使用堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]+o1[1])-(o2[0]+o2[1]);
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(new int[]{nums1[i],nums2[j]});
            }

            int[] peek = pq.peek();
            while (i+1<nums1.length && !pq.isEmpty() && (nums1[i+1]+nums2[0])>(peek[0]+peek[1]) && k>0){
                int[] part = pq.poll();
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(part[0]);
                temp.add(part[1]);
                res.add(temp);
                k--;
                peek = pq.peek();
            }
            if(k==0){
                break;
            }
        }
        while (k>0 && !pq.isEmpty()){
            int[] part = pq.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(part[0]);
            temp.add(part[1]);
            res.add(temp);
            k--;
        }
        return res;
    }


    @Test
    public void test(){
        lc373 lc = new lc373();
        List<List<Integer>> lists = lc.kSmallestPairs(new int[]{1, 7,11}, new int[]{2,4,6}, 3);
        System.out.println(lists);
    }
}
