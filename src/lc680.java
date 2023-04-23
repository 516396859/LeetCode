import org.junit.Test;

public class lc680 {

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while (left<right){
            while (left<right && s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            break;
        }

        if(left>=right){
            return true;
        }
        return false;
    }
    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        while (left<right){
            while (left<right && s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            if(left>=right){
                //s为回文串
                return true;
            }

            if(left<right){
                return isPalindrome(s.substring(left,right)) || isPalindrome(s.substring(left+1,right+1));
            }
        }
        return false;
    }

    @Test
    public void test(){
        lc680 lc = new lc680();
        boolean count= lc.validPalindrome("abc");
        System.out.println(count);
    }
}
