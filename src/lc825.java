import org.junit.Test;

import java.util.Arrays;

public class lc825 {


    public int accept(int[] ages , int k){
        // 左指针指向第一个人，右指针指向自己，找左边第一个满足条件的下标，返回满足条件的人数
        int left = 0;
        int right = k;
        int age = ages[k];

        while (k+1<ages.length){
            if(ages[k+1]==ages[k]){
                right = k+1;
                k++;
            } else {
                break;
            }
        }

        while(left+1<right){
            int mid = left +(right-left)/2;
            if((ages[mid]>0.5*age+7) && ages[mid]<=age ){
                right = mid;
            }else {
                left = mid;
            }
        }

        if(ages[left]>0.5*age+7 && ages[left]<=age  ){
             return k-left;
        }

        if(ages[right]>0.5*age+7 && ages[right]<=age ){
            return k-right;
        }

        return  0;
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            count+=accept(ages,i);
        }
        return count;
    }


    @Test
    public void test(){
        lc825 lc = new lc825();
        int i = lc.numFriendRequests(new int[]{118,14,7,63,103});
        System.out.println(i);
    }
}
