import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class lc1590 {

    public int minEqual(ArrayList<Integer> arr, int i, int mod) {
        //递归返回值
        if(mod==0){
            return 0;
        }

        if(i<0 || mod<0){
            return 999999;
        }

        if(i==0){
            if(arr.get(0)==mod){
                return 1;
            }
        }
        int res2 = Integer.MAX_VALUE-10000;
        int res1 = Integer.MAX_VALUE-10000;
        //最后一个不取
        if(mod>=0){
            res1 = minEqual(arr, i - 1, mod);
        }
        //取最后一个
//        System.out.println((mod - arr.get(i))+"   "+mod+"   "+arr.get(i));
        if(mod>=arr.get(i)){
            res2 = minEqual(arr, i - 1, mod - arr.get(i)) + 1;
        }

        return Math.min(res2, res1);
    }


    public int minSubarray(int[] nums, int p) {
        int mod = 0;
        for (int a : nums) {
            mod += a % p;
            mod = mod % p;
        }

        if(mod==0){
            return 0;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        //背包问题，从nums取若干个数等于mod，要求次数最小
        for (int a : nums) {
            if (a <= mod) {
                arr.add(a);
            }
        }

        int res = minEqual(arr, arr.size() - 1, mod);
        if(res==arr.size() || res==999999){
            return -1;
        }else {
            return res;
        }
    }


    @Test
    public void test() {
        lc1590 lc = new lc1590();
        int i = lc.minSubarray(new int[]{17,3,16,12,3,19,1,8,5,8}, 54);
        System.out.println(i);
    }
}