import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        String colors =sc.next();
        int[] count = new int[3];
        for (char c:colors.toCharArray()){
            if(c=='R'){
                count[0]++;
            } else if (c == 'G') {
                count[1]++;
            }else{
                count[2]++;
                System.out.println();
            }
        }
    }
}
