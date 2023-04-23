import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(); //n行
            int m = sc.nextInt(); //m个大列
            int a = sc.nextInt(); //每个大列 a 小列
            sc.nextLine();

            ArrayList<ArrayList<String>> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                String[] split = s.split("\\ ");
                ArrayList<String> point = new ArrayList<String>(Arrays.asList(split));
                arr.add(point);
            }
            ArrayList<ArrayList<String>> org = (ArrayList<ArrayList<String>>)arr.clone();
            // 完成向后移动一行
            ArrayList<String> temp = new ArrayList<String>(arr.get(0));
            arr.remove(0);
            arr.add(temp);

            for (int i = 0; i < n; i++) {
                //对于每一行，大列向后移动
                ArrayList<String> row = new ArrayList<>(arr.get(i));
                String s = row.get(0);
                row.remove(0);
                row.add(s);
                arr.set(i,row);
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m ; j++) {
                    String s2 = arr.get(i).get(j);
                    String s1 = org.get(i).get(j);
                    for (int k = 0; k < a; k++) {
                        if(s1.charAt(k)!=s2.charAt(k)){
                            count ++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
}
