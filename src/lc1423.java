import org.junit.Test;

import java.util.HashMap;

public class lc1423 {
//    HashMap<String,Integer> map;
//
//    public int maxscore(int[] cardPoints,int left,int right,int k){
//        if(k==1 && left<right){
//            int value = Math.max(cardPoints[right],cardPoints[left]);
//            map.put(""+left+right+k,value);
//            return value;
//        }
//
//        int a = 0;
//        int b = 0;
//
//        if(map.containsKey(""+(left+1)+right+(k-1))){
//            a = map.get(""+(left+1)+right+(k-1))+cardPoints[left];
//        }else {
//            a = maxscore(cardPoints,left+1,right,k-1)+cardPoints[left];
//        }
//
//        if(map.containsKey(""+left+(right-1)+(k-1))){
//            b = map.get(""+(left)+(right-1)+(k-1))+cardPoints[right];
//        }else {
//            b = maxscore(cardPoints,left,(right-1),k-1)+cardPoints[right];
//        }
//        return Math.max(a,b);
//
//    }

    public int maxScore(int[] cardPoints, int k) {
        //动态规划
//        map = new HashMap<>();
//        return maxscore(cardPoints,0,cardPoints.length-1,k);

        int n = cardPoints.length-k;
        int[] B = new int[cardPoints.length];
        B[0] = cardPoints[0];
        for (int i = 1; i < cardPoints.length; i++) {
            B[i] = B[i-1]+cardPoints[i];
        }

        if(cardPoints.length==k){
            return B[cardPoints.length-1];
        }

        int minn = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            int sum = B[i+n-1]-B[i]+cardPoints[i];
            if(sum<minn){
                minn = sum;
            }
        }
        return B[cardPoints.length-1]-minn;
    }

    @Test
    public void test(){
        lc1423 lc = new lc1423();
        int i = lc.maxScore(new int[]{9,7,7,9,7,7,9},7);
        System.out.println(i);
    }
}