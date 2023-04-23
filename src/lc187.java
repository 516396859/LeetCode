import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class lc187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<=len-10;i++){
            left = i;
            right = i+10;
            String sub = s.substring(left, right);

            if(map.containsKey(sub)){
                map.put(sub,map.get(sub)+1);
            }else{
                map.put(sub,1);
            }
        }

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            Integer value = map.get(key);
            if(value>1){
                list.add(key);
            }
        }

        return list;

    }

    @Test
    public void my_test() {
        lc187 lc = new lc187();
        List<String> res = lc.findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(res);
    }
}
