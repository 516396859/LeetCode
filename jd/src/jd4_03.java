import java.util.ArrayList;

public class jd4_03 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(Integer.valueOf(1));
        arr.add(Integer.valueOf(2));
        Integer[] res = arr.toArray(new Integer[arr.size()]);
    }
}
