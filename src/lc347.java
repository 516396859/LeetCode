import org.junit.Test;

import java.util.*;

public class lc347 {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for(int a: nums){
            //  map.put(num,map.getOrDefault(num,0)+1);
            if(map.containsKey(a)){
                map.replace(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet(); //转为集合
        ArrayList<Map.Entry<Integer, Integer>> arr = new ArrayList<>(entries); //转为数组

        for (int i = 0; i < arr.size(); i++) {
            pq.add(arr.get(i));
        }

//        Collections.sort(arr, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o1.getValue()-o2.getValue();
//            }
//        });


        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> poll = pq.poll();
            res[i] = poll.getKey();
        }
        return res;
    }
    
    @Test
    public void test(){
        lc347 lc = new lc347();
        int[] res = lc.topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 3, 4}, 2);
    }
}
