import org.junit.Test;

public class lc650 {
    public int minSteps(int n) {

        if (n < 5) {
            return n;
        }

        if (n % 2 == 0) {
            //n为偶数
            return minSteps((int) (n / 2)) + 2;
        } else {
            //是否是以前某个奇数的倍数，是的话如下
            int ood = n - 2;
            while (ood >= 3) {
                if (n % ood == 0) {
                    return minSteps(ood) + (int) (n / ood);
                }
                ood -= 2;
            }
            if (ood == 1) {
                return n;
            }
        }
        return 0;

    }

    @Test
    public void my_test() {
        lc650 lc = new lc650();
        int i = lc.minSteps(9);
        System.out.println(i);
    }
}
