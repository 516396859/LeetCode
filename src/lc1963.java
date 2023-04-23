public class lc1963 {
    public int minSwaps(String s) {
        if(s==null || s.equals("[]")){
            return 0;
        }

        int n = s.length();
        String left = s.substring(0,(int)(n/2)-1);
        String right = s.substring((int)(n/2),n);
        return 0;
    }
}
