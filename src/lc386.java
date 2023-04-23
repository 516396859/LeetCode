import org.junit.Test;

import java.util.*;

public class lc386 {
    int[] item;
    int[] visit;
    List<Integer> res;

    public void dfs(int[] nums,int step,int n){
        if(step==n){
            for(int a : item){
                res.add(a);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visit[i]==0){
                visit[i]=1;
                item[step] = nums[i];

                if(step>0 && ((item[step-1]+"").compareTo(item[step]+""))>0){
                    visit[i]=0;
                    return;
                }

                dfs(nums,step+1,n);
                visit[i]=0;
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
//        item = new int[n];
//        visit = new int[n];
//        res = new ArrayList<Integer>();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i]=i+1;
//        }
//        dfs(arr,0,n);
//        return res;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }

        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1+"").compareTo(o2+"");
            }
        });

        return arr;

    }

    @Test
    public void test(){
        lc386 lc = new lc386();
        List<Integer> permute = lc.lexicalOrder(10);

//        System.out.println("10".compareTo("1"));

    }
}
