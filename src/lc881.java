import org.junit.Test;

import java.util.Arrays;

public class lc881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int count = 0;

        while (left<right){
            while(left<right && (people[left]+people[right])>limit){
                right--;
                count++;
            }
            if(left<right && (people[left]+people[right])<=limit){
                left++;
                right--;
                count++;
            }
        }
        if(left==right){
            count++;
        }
        return count;
    }

    @Test
    public void test(){
        lc881 lc = new lc881();
        int i = lc.numRescueBoats(new int[]{2,1,4,3}, 4);
        System.out.println(i);
    }
}
