import java.util.Arrays;
import java.util.Collection;

public class lc1053 {
    public int[] prevPermOpt1(int[] arr) {
        //倒序使用单调栈
        int idx = -1;
        int change = -1;
        int maz = Integer.MIN_VALUE;
        for (int i = arr.length-1; i >0; i--) {
            if(arr[i-1]>arr[i]){
                idx = i-1;
                break;
            }
        }
        if(idx==-1){
            return arr;
        }

        for (int i = idx+1; i < arr.length ; i++) {
            if(arr[i]<arr[idx] && arr[i]>maz){
                maz = arr[i];
                change = i;
            }
        }
        int temp = arr[idx];
        arr[idx] = arr[change];
        arr[change] = temp;
        return arr;
    }
}
