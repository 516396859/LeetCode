import org.junit.Test;

public class lc125 {

    public boolean isPalindrome(String s) {
        int left=0;
        int right = s.length()-1;

        while (left<right){
            while (left<right && !Character.isLetterOrDigit(s.charAt(left))){
                //不满足 左指针往右移动
                left++;
            }
            while (left<right && !Character.isLetterOrDigit(s.charAt(right))){
                //不满足，右指针往左移动
                right--;
            }
            if(left<=right && Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }

    @Test
    public void test(){
        lc125 lc = new lc125();
        boolean count= lc.isPalindrome("race a car");
        System.out.println(count);
    }
}
