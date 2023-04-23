import org.junit.Test;

import java.util.*;
public class bs10 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 根据输入计算最大收益
     * @param M double浮点型 初始资金
     * @param N int整型 历史价格天数
     * @param historyPrices double浮点型一维数组 N天历史价格
     * @param K int整型 最大允许交易次数
     * @return double浮点型
     */
//    public double get_max_profit (double M, int N, double[] historyPrices, int K) {
//        K = K*2;
//        // write code here
//        if(historyPrices.length<=1){
//            return 0;
//        }
//        double[] sell = new double[K+1];
//        double[] buy = new double[K+1];
//
//        //初始化
//        for (int i = 1; i < K+1; i++) {
//            buy[i] = -historyPrices[0];
//        }
//
//        for (int i = 1; i < N; i++) {
//            for (int j = 1; j <= K ; j++) {
//                buy[j] = Math.max(buy[j],sell[j-1]-historyPrices[i]);
//                sell[j] = Math.max(sell[j],buy[j]+historyPrices[i]);
//            }
//        }
//        return sell[K]*(M/buy[0]);
//    }

    public double get_max_profit (double M, int N, double[] historyPrices, int K) {
        // write code here
        double[][] dp = new double[K+1][N];
        for (int i =1;i<=K;i++){
            double pric = -historyPrices[0];
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i][j-1],pric+historyPrices[j]);
                pric = Math.max(pric,dp[i-1][j]-historyPrices[j]);
            }
        }
        return dp[K][N-1]*M;
    }

    @Test
    public void test(){
        bs10 bs = new bs10();
        bs.get_max_profit(10000,7,new double[]{1.0,2.0,1.0,2.0,2.0,3.0,2.0},2);
    }
}

