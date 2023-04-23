import org.junit.Test;

import java.util.*;

public class lc1 {


    public class tuple{
        int idx;
        int num;
        public tuple(int a,int b){
            this.idx = a;
            this.num = b;
        }
    }

    public int[] twoSum(int[] nums, int target) {

        ArrayList<tuple> tuples = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            tuples.add(new tuple(i,nums[i]));
        }

        Collections.sort(tuples, new Comparator<tuple>() {
            @Override
            public int compare(tuple o1, tuple o2) {
                return o1.num-o2.num;
            }
        });


        int left = 0;
        int right = nums.length-1;

        while (left<right){
            while (left<right && (tuples.get(left).num+tuples.get(right).num)<target){
                left++;
            }
            while (left<right && (tuples.get(left).num+tuples.get(right).num)>target){
                right--;
            }
            if(tuples.get(left).num+tuples.get(right).num==target){
                return new int[]{tuples.get(left).idx,tuples.get(right).idx};
            }
        }

        return new int[]{0,0};
    }

    @Test
    public void test(){
        lc1 lc = new lc1();
        int[] ints = lc.twoSum(new int[]{3,2,4}, 6);
        System.out.println(ints[0]+" "+ints[1]);
    }
}
