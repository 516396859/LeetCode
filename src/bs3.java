import org.junit.Test;

public class bs3 {
    public int recur(int n){
        if(n<=2){
            return n;
        }
        return recur(n-1) + recur(n-2);
    }

    @Test
    public void test(){
        bs3 bs = new bs3();
        int recur = bs.recur(1);
        System.out.println(recur);
    }
}
