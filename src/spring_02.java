import org.junit.Test;

import java.util.HashSet;

public class spring_02 {
    public int adventureCamp(String[] expeditions) {
        int[] newExped = new int[expeditions.length];
        HashSet<String> set = new HashSet<>();

        set.add("");

        String path0 = expeditions[0];
        String[] places0 = path0.split("->");
        for (int j = 0; j < places0.length; j++) {
                set.add(places0[j]);
        }

        for (int i = 1; i < expeditions.length; i++) {
            String path = expeditions[i];
            String[] places = path.split("->");
            for (int j = 0; j < places.length; j++) {
                if(!set.contains(places[j])){
                    newExped[i]++;
                    set.add(places[j]);
                }
            }
        }

        int max = 0;
        int idx = -1;
        for (int i = 0; i < newExped.length; i++) {
            if(newExped[i]>max){
                max = newExped[i];
                idx = i;
            }
        }
        if(max==0){
            return -1;
        }else {
            return idx;
        }
    }

    @Test
    public void test(){
        int i = adventureCamp(new String[]{"Alice->Dex", "", "Dex"});
        System.out.println(i);
    }
}
