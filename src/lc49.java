import java.util.*;

public class lc49 {

    public String getId(String s){
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c-'a'] += 1;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            if(arr[i]>0){
                sb.append(arr[i]+"*"+i);
            }
        }
        return sb.toString();
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs){
            String id = getId(s);
            if(map.containsKey(id)){
                ArrayList<String> list = map.get(id);
                list.add(s);
                map.put(id,list);
            }else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(id,list);
            }
        }
        for ( Map.Entry<String, ArrayList<String>> ent:map.entrySet()){
            res.add(ent.getValue());
        }

        return res;
    }
}
