import org.junit.Test;

public class bs2 {
    public int func(int[] arr){
        //前缀和
        int[] B =new int[arr.length];
        int[] A =new int[arr.length];

        B[0] = arr[0];
        A[arr.length-1] = arr[arr.length-1];

        //构建前缀和
        for (int i = 1; i < arr.length; i++) {
            B[i] = B[i-1] + arr[i];
        }

        //构建后缀和
        for (int i = arr.length-2; i >=0; i--) {
            A[i] = A[i+1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int before = B[i] - arr[i];
            int after = A[i] - arr[i];
            if(after==before){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        bs2 bs = new bs2();
        int res = bs.func(new int[]{2, 1,-1});
        System.out.println(res);
    }
}
