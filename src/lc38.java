import org.junit.Test;

public class lc38 {

    public String getresult(String s){

        if(s.equals("1")){
            return "11";
        }

        String res = "";
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)){
                count ++;
            }else {
                res += count+""+s.charAt(i-1);
                count = 1;
            }
            if(i==s.length()-1){
                res += count+""+s.charAt(i);
            }
        }
        return res;
    }
    public String countAndSay(int n) {

        if(n==1){
            return "1";
        }

        String last="1";
        String curr="";
        for (int i = 2; i <= n ; i++) {
             curr = getresult(last);
             last = curr;
        }
        return curr;
    }

    @Test
    public void test(){
        lc38 lc = new lc38();
        String s = lc.countAndSay(1);
        System.out.println(s);
    }
}
