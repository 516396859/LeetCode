import java.util.Scanner;

public class bs6 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                String s = sc.next();
                String t = sc.next();
                if (canTransform(s, t)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
            sc.close();
        }

    private static boolean canTransform(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        // 动态规划
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n] >= n;
    }
}