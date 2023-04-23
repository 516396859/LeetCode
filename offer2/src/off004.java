import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class off004 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a: nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }

        for (int a: nums){
            if(map.get(a)==1){
                return a;
            }
        }
        return -1;
    }
}
