import java.util.Scanner;

public class bs9 {
    public static boolean isFlowerNumner(int num){
        int n = num;
        int p = (num+"").length();
        int sum = 0;
        for (int i = 0; i < p; i++) {
            int d = num%10;
            sum+=Math.pow(d,p);
            num /= 10;
        }

        if(sum==num){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = num-1; i >=10; i--) {
            if (isFlowerNumner(i)){
                System.out.println(i);
            }
        }
    }
}
