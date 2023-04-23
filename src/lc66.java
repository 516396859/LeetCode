import java.util.ArrayList;

public class lc66 {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        ArrayList<Integer> arrres = new ArrayList<>();

        for (int i = digits.length-1; i > 0; i--) {
            if(digits[i]>9){
                arrres.add(digits[i]%10);
                digits[i-1] ++;
            }else {
                arrres.add(digits[i]);
            }
        }
        if(digits[0]>9){
            arrres.add(digits[0]%10);
            arrres.add(1);
        }else {
            arrres.add(digits[0]);
        }

        int[] res = new int[arrres.size()];
        for (int i = arrres.size()-1; i >=0 ; i--) {
            res[arrres.size()-i-1] = arrres.get(i);
        }
        return res;
    }
}
