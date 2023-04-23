public class offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int nn=0;
        int mm=0;


        for (int i = 0; i < n; i++) {
            if(matrix[i][0]<target){
                nn = i;
            }else {
                break;
            }
        }

        for (int j = 0; j < m; j++) {
            if(matrix[0][j]<target){
                mm = j;
            }else {
                break;
            }
        }

        for (int i = 0; i <=nn ; i++) {
            for (int j = 0; j <=mm; j++) {
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }

        return false;
    }
}
