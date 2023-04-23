import java.util.HashSet;

public class offer03 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : nums){
            if(!set.contains(a)){
                set.add(a);
            }else {
                return a;
            }
        }
        return -1;
    }
}
