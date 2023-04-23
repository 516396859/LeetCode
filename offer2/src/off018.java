import org.junit.Test;

public class off018 {

    public boolean isPalind(String s){
        if(s==null||s.equals("")||s.length()==1){
            return true;
        }

        if((s.charAt(0)!=s.charAt(s.length()-1))){
            return false;
        }

        return isPalind(s.substring(1,s.length()-1));
    }
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s1.charAt(i);
            if((c>='a'&&c<='z')||(c>='0'&&c<='9')){
                char c1 = Character.toLowerCase(c);
                res+=c1;
            }
        }
        return isPalind(res);
    }

    @Test
    public void test(){
        off018 of = new off018();
        boolean op = of.isPalindrome("0P");
        System.out.println(op);
    }
}
