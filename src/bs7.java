import java.util.Scanner;
public class bs7 {
    public static boolean isFlowerNumber(int num){
        int p = (num+"").length();
        int sum = 0;
        int n = num;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit,p);
            n /= 10;
        }
        return sum == num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = num-1; i >=10; i--) {
            if(isFlowerNumber(i)){
                System.out.println(i);
            }
        }
    }
}
