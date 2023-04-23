import org.junit.Test;

public class lc375 {


    public int maxMoney(int start,int end ,int target){
        if(start==end){
            return 0;
        }

        for (int i = start; i <= end ; i++) {
            if(target==i){
                return 0;
            }

            if(target>i){
                return i+maxMoney(i+1,end,target);
            }

            if(target<i){
                return i+maxMoney(1,i-1,target);
            }
        }
        return 0;
    }

    public int getMoneyAmount(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res,maxMoney(1,n,i));
        }
        return res;
    }

    @Test
    public void test(){
        lc375 lc = new lc375();
        int moneyAmount = lc.getMoneyAmount(10);
        System.out.println(moneyAmount);
    }
}
