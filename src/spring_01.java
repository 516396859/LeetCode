import java.util.ArrayList;

public class spring_01 {
    public int[] supplyWagon(int[] supplies) {
        int length = supplies.length/2;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < supplies.length; i++) {
            arr.add(supplies[i]);
        }
        while (arr.size()>length){
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 1; i < arr.size() ; i++) {
                if(arr.get(i)+arr.get(i-1)<min){
                    min = arr.get(i)+arr.get(i-1);
                    idx = i;
                }
            }

            arr.set(idx-1,min);
            arr.remove(idx);
        }

        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
