import org.junit.Test;

public class offer11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;


        while (left+1<right){
            int mid = left + (right-left)/2;
            if(numbers[mid]<numbers[right]){
                right = mid;
            }else if(numbers[mid]>numbers[right]){
                left = mid;
            }else {
                //无法判断左搜还是右搜，只能线性搜索
                right--;
            }
        }

        return Math.min(numbers[left],numbers[right]);

    }
}
