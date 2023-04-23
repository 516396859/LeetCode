import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class bs1 {
    public static boolean func(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }




        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()){
            Integer key = it.next();
            Integer count = map.get(key);
            if(set.contains(count)){
                return false;
            }else {
                set.add(count);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = func(new int[]{1, 2,2,3,3,3,4,4,4,4});
        System.out.println(res);
    }


}
