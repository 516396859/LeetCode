import org.junit.Test;

public class lc1653 {
    public int minimumDeletions(String s) {
        //前缀和问题，要么是aaabbbb这种某个b开始的串，要么aaaaaa这种不含b，
        // 所以找串中某个b左边的a和右边的b加上自己就是最大串，去掉的就是最少次数
        // 还有一种可能是串中全是a，这种最少次数就是b的个数
        int[] A = new int[s.length()]; //统计第i个字符的a的个数
        int[] B = new int[s.length()]; //统计前i个字符的b的个数
        if(s.charAt(0)=='a'){
            A[0] = 1;
        }else {
            B[0] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='a'){
                A[i] = A[i-1] + 1;
                B[i] = B[i-1];
            }else {
                B[i] = B[i-1] + 1;
                A[i] = A[i-1];
            }
        }
        int maxx = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='b'){
                int len = A[i]+(B[s.length()-1]-B[i]+1);
                maxx = Math.max(maxx,len);
            }
        }

        return Math.min(s.length()-maxx,B[s.length()-1]);
    }

    @Test
    public void test(){
        lc1653 lc = new lc1653();
        int res = lc.minimumDeletions("aaabaa");
        System.out.println(res);
    }
}
