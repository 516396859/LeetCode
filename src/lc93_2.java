import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class lc93_2 {
    List<String> res = new ArrayList<>();
    int orgLen = 0;
    public void dfs(StringBuffer sb,int startIndex){
        if(sb.length()==orgLen+3 && isValid(sb,startIndex,sb.length()-1)){
            res.add(sb.toString());
            return;
        }
        for (int i = startIndex; i < sb.length(); i++) {
            if(!isValid(sb,startIndex,i)){
                break;
            }
            sb.insert(i+1,'.');//注意是放在i的后面，所以是+1
            dfs(sb,i+2);
            sb.deleteCharAt(i+1);
        }
    }

    public boolean isValid(StringBuffer sb,int start,int end){
        //判断字符串是否合法
        if(end<start){
            return false;
        }
        String s = sb.substring(start, end + 1);
        if(s.equals("0")){
            return true;
        }
        if(s.length()>3 || Integer.parseInt(s)>255 || s.charAt(0)=='0'){
            return false;
        }
        return true;
    }
    public List<String> restoreIpAddresses(String s) {
        StringBuffer sb = new StringBuffer(s);
        orgLen = sb.length();
        dfs(sb,0);
        return res;
    }

    @Test
    public void test(){
        lc93_2 lc = new lc93_2();
        List<String> strings = lc.restoreIpAddresses(  "101023");
        System.out.println(strings);
    }
}
