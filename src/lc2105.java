import org.junit.Test;

public class lc2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left =0;
        int right = plants.length-1;
        int count = 0;

        int Bcap = capacityB;
        int Acap = capacityA;

        while (left<right){
            if(Acap<plants[left]){
                count ++;
                Acap = capacityA - plants[left];
            }else {
                Acap -= plants[left];
            }

            if(Bcap<plants[right]){
                count ++;
                Bcap = capacityB - plants[right];
            }else {
                Bcap -= plants[right];
            }

            left++;
            right--;
        }
        if(left==right && Math.max(Acap,Bcap)<plants[left]){
            count++;
        }
        return count;
    }

    @Test
    public void test(){
        lc2105 lc = new lc2105();
        int i = lc.minimumRefill(new int[]{2,2,3,3}, 5,5);
        System.out.println(i);
    }
}
