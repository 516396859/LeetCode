import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class lc524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        int maxx = 0 ;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean contains = map.keySet().contains(c);
            if(!contains){
                map.put(c,1);
            }else {
                map.replace(c,map.get(c)+1);
            }
        }



        for (String w:dictionary){
            int flag = 0 ;
            HashMap<Character, Integer> wmap = new HashMap<Character, Integer>();
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                boolean contains = wmap.keySet().contains(c);
                if(!contains){
                    wmap.put(c,1);
                }else {
                    wmap.replace(c,map.get(c)+1);
                }
            }

            Set<Character> keys = wmap.keySet();
            for(Character c: keys){
                if(!map.keySet().contains(c)){
                    flag = 1;
                    break;
                }else if(wmap.get(c)>map.get(c)){
                    flag = 1;
                    break;
                }
            }

            if(flag==0){
                if(w.length()>maxx){
                    maxx = w.length();
                    res = w;
                }
                if(w.length()==maxx && w.compareTo(res)<0){
                    res = w ;
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        lc524 lc = new lc524();
        List<String> array = new ArrayList<>();
        array.add("ale");
        array.add("apple");
        array.add("monkey");
        array.add("plea");
        String res = lc.findLongestWord("abpcplea",array);
        System.out.println(res);
    }
}
