import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc216 {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    int sum = 0;

    public void dfs(int k, int n, int step) {
        if (temp.size() == k && sum == n) {
            ArrayList<Integer> clone = (ArrayList<Integer>) temp.clone();
            res.add(clone);
            return;
        }

        for (int i = step; i <= 9 ; i++) { // 优化  9 - (k - temp.size())
            temp.add(i);
            sum += i;
            dfs(k, n, i + 1);
            sum -= i;
            temp.remove(temp.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return res;
    }

    @Test
    public void test() {
        lc216 lc = new lc216();
        List<List<Integer>> combine = lc.combinationSum3(3, 6);
        System.out.println(combine);
    }
}
