import java.util.*;

public class lc451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }


        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<Character, Integer>> arr = new ArrayList<>(entries);
        Collections.sort(arr, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> a :arr){
            Integer value = a.getValue();
            Character key = a.getKey();
            for (int i = 0; i < value; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
