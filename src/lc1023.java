import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class lc1023 {
    public boolean match(String s,String pattern){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }else {
                map.put(c,map.get(c)-1);
            }
        }

        Set<Character> characters = map.keySet();
        for (char c :characters){
            if(Character.isUpperCase(c) && map.get(c)!=0){
                return false;
            }else if (map.get(c)<0){
                return false;
            }
        }
        return true;
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String s : queries){
            res.add(match(s,pattern));
        }
        return res;
    }
}
