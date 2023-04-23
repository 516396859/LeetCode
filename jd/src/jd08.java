import java.util.ArrayList;
import java.util.List;

public class jd08 {


    public List<List<Integer>> dtgh(int[] nums,int end){
        if(end==0){
            List<List<Integer>> lis = new ArrayList<>();
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(nums[end]);
            lis.add(arr);
            return lis;
        }

        List<List<Integer>> pre = dtgh(nums, end - 1);
        List<List<Integer>> lis = new ArrayList<>();
        for (int i = 0; i < pre.size(); i++) {
            List<Integer> prei = pre.get(i);
            ArrayList<Integer> temp = new ArrayList<>(prei);
            lis.add(temp);
            ArrayList<Integer> temp2 = new ArrayList<>(prei);
            temp2.add(nums[i]);
            lis.add(temp2);
        }
        return lis;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return dtgh(nums,nums.length-1);
    }
}
