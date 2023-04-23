import org.junit.Test;

public class lc474 {
    int[][][] mem;
    public int zeroNum(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                count++;
            }
        }
        return count;
    }

    public int dp(String[] strs,int i,int m,int n){
        if(m<0||n<0){
            return 0;
        }
        int zero = zeroNum(strs[i]);
        int one = strs[i].length()-zero;
        if(i==0 && zero<=m && one<=n){
            return 1;
        } else if (i == 0) {
            return 0;
        }



        if(mem[i-1][m][n]==-1){
            mem[i-1][m][n] = dp(strs,i-1,m,n);
        }

        int res = mem[i-1][m][n];

        if(m>=zero && n>=one ){
            if(mem[i-1][m-zero][n-one]==-1){
                mem[i-1][m-zero][n-one]=dp(strs,i-1,m-zero,n-one) + 1;
            }
            res = Math.max(mem[i-1][m-zero][n-one] ,res);
        }
        return res;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[n][j][k] 前n个数字j个0,k个1的最长子集
        // dp[n][j] = max(dp[n-1][j][k],dp[n-1][j-arr[n]_0][k-arr[n]_1]+1)
        // 使用递归动态规划更好实现
        mem = new int[strs.length][m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    mem[i][j][k] = -1;
                }
            }
        }
        int dp = dp(strs, strs.length - 1, m, n);
        return dp;
    }

    @Test
    public void test(){
        lc474 lc = new lc474();
        int dp = lc.findMaxForm(new String[]{"10", "0"}, 1, 0);
        System.out.println(dp);
    }
}
