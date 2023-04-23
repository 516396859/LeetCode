import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class lc17 {

    ArrayList<String> res = new ArrayList<String>();
    StringBuffer temp = new StringBuffer();
    String[] dic = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void dfs(char[] digits,int next){
        if(temp.length()==digits.length){
            res.add(temp.toString());
            return;
        }
        int idx = digits[next]-'0';
        char[] chars = dic[idx].toCharArray();
        for (int j = 0; j < chars.length; j++) {
            temp.append(chars[j]) ;
            dfs(digits,next+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return res;
        }
        char[] dig = digits.toCharArray();
        dfs(dig,0);
        return res;
    }

    @Test
    public void test() {
        lc17 lc = new lc17();
        List<String> strings = lc.letterCombinations("23");
        System.out.println(strings);
    }

}
