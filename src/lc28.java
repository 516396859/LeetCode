import org.junit.Test;

public class lc28 {
    public int strStr(String haystack, String needle) {
        int i = haystack.indexOf(needle);
        return i;
    }

    @Test
    public void my_test(){
        lc28 lc = new lc28();
        int i = lc.strStr("sadbutsad","sad");
        System.out.println(i);
    }
}
