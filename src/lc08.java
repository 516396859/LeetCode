public class lc08 {
    public int multiply(int A, int B) {
        int min = Math.min(A,B);
        int max = Math.max(A,B);
        int res = 0;
        for (int i = 0; i < min; i++) {
            res += max;
        }
        return res;
    }
}
