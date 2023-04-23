import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class lc179 {
    public String largestNumber(int[] nums) {
        ArrayList<String> arr = new ArrayList<String>();
        String res = "";
        for(int a:nums){
            arr.add(a+"");
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String a = s1+s2;
                String b = s2+s1;
                return -1*a.compareTo(b);
            }
        };

        arr.sort(comparator);
        for (String s:arr){
            res += s;
        }

        if(res.charAt(0)=='0'){
            return "0";
        }

        return res;
    }

    @Test
    public void test(){

        /*
        * 使用排序比较器，两两拼接比较
        * 很简单就能排序
        * */

        lc179 lc = new lc179();
        String s = lc.largestNumber(new int[]{432,43243,999999999,9999,999,99,9,9,});
        System.out.println(s);
    }
}