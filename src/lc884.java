import java.util.*;

public class lc884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();

        for(String s : ss1){
            if(map.containsKey(s)){
                map.put(s,1);
            }else {
                map.put(s,map.get(s)+1);
            }
        }

        for(String s : ss2){
            if(map.containsKey(s)){
                map.put(s,1);
            }else {
                map.put(s,map.get(s)+1);
            }
        }

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if(map.get(s)<=1){
                res.add(s);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
