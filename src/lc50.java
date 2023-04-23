public class lc50 {
    public double myPow(double x, int n) {
        double value = pow(x,Math.abs(n));
        if(n>=0){
            return value;
        }else {
            return 1/value;
        }
    }

    public double pow(double x, int n){
        //使用分治法
        if(n==1){
            return x;
        }
        if(n%2==0){
            double temp = myPow(x,(int)(n/2));
            return temp*temp;
        }else {
            double temp = myPow(x,(int)(n/2));
            return temp*temp*x;
            
        }
    }
}
