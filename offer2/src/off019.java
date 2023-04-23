import org.junit.Test;

public class off019 {

    public boolean isValid(String s){

        //return s.equals(new StringBuffer(s).reverse().toString());  快速回文串判断

        int left = 0;
        int right = s.length()-1;

        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        if(s.equals("")||s==null||s.length()==1){
            return true;
        }

        int left = 0;
        int right = s.length()-1;

        while (left<right && (s.charAt(left)==s.charAt(right)) ){
                left++;
                right--;
        }
        if(left>=right){
            return true;
        }
        return isValid(s.substring(left,right))||isValid(s.substring(left+1,right+1));
    }

    @Test
    public void test(){
        off019 of = new off019();
        boolean abc = of.validPalindrome("abc");
        System.out.println(abc);
    }
}
