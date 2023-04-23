import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class lc875 {

    public int isAchieve(int[] piles,int h ,int k){
        int time = 0;
        for(int a:piles){
            int ceil = (int)Math.ceil((double) a / k);
            time += ceil;
        }
        if(time>h){
            return 0;
        }
        return 1;
    }



    public int minEatingSpeed(int[] piles, int h) {
        //此题使用需要找一个k看看是否符合条件，那么找一个数的问题一般可以使用二分查找

        int max = 0;
        for(int a:piles){
            if(a>max){
                max = a;
            }
        }

        int left = 1;
        int right = max;
        int res = max;

        while(left+1<right){
            int mid = left+(right-left)/2;
            if(isAchieve(piles,h,mid)==1 && mid<res){
                res = mid;
                right = mid;
            } else if (isAchieve(piles, h, mid) == 0) {
                left = mid;
            }
        }

        if(isAchieve(piles,h,left)==1 && left<res){
            res = left;
        }

        if(isAchieve(piles,h,right)==1 && right<res){
            res = right;
        }
        return res;
    }

    @Test
    public void test(){
        lc875 lc = new lc875();
        int count = lc.minEatingSpeed(new int[]{30,11,23,4,20},6);
        System.out.println(count);
    }
}
