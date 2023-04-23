import org.junit.Test;

public class lc2379 {
    public int minimumRecolors(String blocks, int k) {
        // 滑动窗口
        int res ;
        int n = blocks.length();
        char pre_first ;
        int count = 0 ;
        pre_first = blocks.charAt(0);

        for (int i = 0; i < k; i++) {
            if(blocks.charAt(i)=='W'){
                count++;
            }
        }
        res = count;

        for (int i = 1; i <= n - k; i++) {
//            if(blocks.charAt(i+k-1)=='W' && pre_first=='W'){
//                pre_first = blocks.charAt(i);
//                continue;
//            }
//            if(blocks.charAt(i+k-1)=='W' && pre_first=='B'){
//                count++;
//                pre_first = blocks.charAt(i);
//            }
//            if(blocks.charAt(i+k-1)=='B' && pre_first=='W'){
//                count--;
//                pre_first = blocks.charAt(i);
//            }
//            res = Math.min(res,count);
            if(blocks.charAt(i+k-1)==pre_first){
                pre_first = blocks.charAt(i);
                continue;
            } else if (blocks.charAt(i+k-1)=='W' && pre_first=='B') {
                count++;
            } else if (blocks.charAt(i+k-1)=='B' && pre_first=='W') {
                count--;
            }
            pre_first = blocks.charAt(i);
            res = Math.min(res,count);
        }
        return res;
    }

    @Test
    public void test(){
        lc2379 lc = new lc2379();
        int res = lc.minimumRecolors("WBBWWBBWBW", 7);
        System.out.println(res);
    }
}