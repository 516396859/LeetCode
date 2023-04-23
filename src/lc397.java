import org.junit.Test;

import java.util.HashMap;

public class lc397 {

    HashMap<Integer,Integer> map;

    public int dtgh(int n){

        if(n==1){
            return 0;
        }

        if(n%2==0){
            if(!map.containsKey((int)(n/2))){
                map.put((int)(n/2),dtgh((int)(n/2)));
            }
            return map.get((int)(n/2))+1;
        }else {
            if(!map.containsKey((n+1))){
                map.put((n+1),dtgh(n+1));
            }

            if(!map.containsKey(n-1)){
                map.put(n-1,dtgh(n-1));
            }
            return Math.min(map.get(n-1),map.get(n+1))+1;
        }
    }

    public int integerReplacement(int n) {
        map = new HashMap<Integer,Integer>();
        return dtgh(n);
    }


    @Test
    public void test(){
        lc397 lc = new lc397();
        int dtgh = lc.integerReplacement(7);
        System.out.println(dtgh);
    }
}
