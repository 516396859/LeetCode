public class lc326 {
    public boolean isPowerOfThree(int n) {

        if(n==3 || n==1){
            return true;
        }

        if(n==0 || n==2 ){
            return false;
        }

        if(n%3==0){
            return isPowerOfThree((int)(n/3));
        }else {
            return false;
        }
    }
}
