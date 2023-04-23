import java.util.ArrayList;

public class off013 {
    // 前缀和数组
    ArrayList<int[]> arr;
    int[][] matrix;
    public off013(int[][] matrix) {
        this.matrix = matrix;
        this.arr = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int[] mat = matrix[i];
            int[] B = new int[m];
            B[0] = mat[0];
            for (int j = 1; j < m; j++) {
                B[j] = B[j-1] + mat[j];
            }
            arr.add(B);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            int[] B = arr.get(i);
            sum+=(B[col2]-B[col1]+matrix[i][col1]);
        }
        return sum;
    }
}
