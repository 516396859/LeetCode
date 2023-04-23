import java.util.HashMap;
import java.util.HashSet;

public class offer50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (Character c : s.toCharArray()){
            if(map.get(c)==1){
                return c;
            }
        }
        return ' ';
    }
}
