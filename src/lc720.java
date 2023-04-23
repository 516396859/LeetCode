import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class lc720 {
    public String longestWord(String[] words) {

        ArrayList<String> arr = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String s:words){
            arr.add(s);
        }
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        String res = "";
        int maxlen = 0;
        for(String s:arr){
            if(s.length()==1 && !set.contains(s)){
                set.add(s);
                if(s.length()>maxlen){
                    maxlen = s.length();
                    res = s;
                }
            }
            if(s.length()>1 && set.contains(s.substring(0,s.length()-1))){
                set.add(s);
                if(s.length()>maxlen){
                    maxlen = s.length();
                    res = s;
                }
            }
        }
        return res;
    }
    @Test
    public void Test(){
        /*
        * 哈希+字典排序
        * */
        lc720 lc = new lc720();
        String res = lc.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
        System.out.println(res);
    }
}
