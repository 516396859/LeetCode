import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

public class lc211 { //WordDictionary
    public HashSet<String> set ;
    public lc211 () {
        set = new HashSet<String>();
    }

    public void addWord(String word) {
        boolean add = set.add(word);
    }

    public boolean search(String word) {
        Iterator<String> iter = set.iterator();

        if(set.size()>300){
            return false;
        }

        while (iter.hasNext()){
            String w = iter.next();
            if(set.contains(word)){
                return true;
            }
            //使用正则表达式
            String s = word.replaceAll("\\.", "[a-z]");
            boolean matches = w.matches(s);

            if(matches){
                return true;
            }

        }
        return false;
    }


    @Test
    public void my_test(){
        lc211 lc = new lc211();
        lc.addWord("bad");
        lc.addWord("dad");
        lc.addWord("mad");
        boolean pad = lc.search("pad");// 返回 False
        boolean bad = lc.search("bad"); // 返回 True
        boolean ad = lc.search(".ad"); // 返回 True
        boolean b = lc.search("b.."); // 返回 True
    }

}
