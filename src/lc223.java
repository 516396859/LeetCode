public class lc223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int left = Math.max(ax1,bx1);
        int right = Math.min(ax2,bx2);

        int up = Math.min(ay2,by2);
        int douwn = Math.max(ay1,by1);
        int res = (right-left)*(up-douwn);
        if(left>=right || douwn>=up ){
            res = 0;
        }
        int sum = (ax2-ax1)*(ay2-ay1)+(bx2-bx1)*(by2-by1);

        return sum-res;

    }
}
