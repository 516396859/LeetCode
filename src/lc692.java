import org.junit.Test;

import java.util.*;

public class lc692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(String s:words){
            if(map.containsKey(s)){
                map.replace(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                Integer v1 = o1.getValue();
                Integer v2 = o2.getValue();
                int eq = v2-v1;
                if(eq==0){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return eq;
            }
        });

        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            res.add(entry.getKey());
        }
        return res;
    }

    @Test
    public void test(){
        lc692 lc = new lc692();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> res = lc.topKFrequent(words, 2);
        for(String s:res){
            System.out.println(s);
        }
    }
}
