import java.util.ArrayList;
import java.util.List;

public class lc51 {
    List<List<String>> res = new ArrayList<>();
    int[] location;
    public void dfs(int n,int startIndex){
        if(n==startIndex){
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if(location[i]==j){
                        sb.append('Q');
                    }else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            res.add(temp);
        }

        for (int i = startIndex; i < n; i++) {

        }

    }
    public List<List<String>> solveNQueens(int n) {
        location = new int[n];
        dfs(n,0);
        return res;
    }
}
