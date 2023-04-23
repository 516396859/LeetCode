import org.junit.Test;

import java.util.ArrayDeque;

public class lc71 {
    public String simplifyPath(String path) {
        ArrayDeque<String> res = new ArrayDeque<>();
        String result="";

        String[] split = path.split("/");
        for(String s:split){
            if(s.equals("") || s.equals(".")){
                continue;
            }

            if(s.equals("..")){
                if(res.size()==0){
                    continue;
                }else {
                    res.removeLast();
                }
            }else{
                res.addLast(s);
            }


        }

        for(String s:res){
            result += "/"+ s;
        }

        if(result.equals("")){
            return "/";
        }else{
            return result;
        }
    }

    @Test
    public void my_test() {
        /*
        * 先切分再使用栈来模拟
        * */
        lc71 lc = new lc71();
        String i= lc.simplifyPath("/a/./b/../../c/");
        System.out.println(i);
    }

}
