import org.junit.Test;

public class lc165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = v1.length > v2.length ? v1.length : v2.length;
        for (int i = 0; i < len; i++) {
            int num1 = 0;
            int num2 = 0;
            if(i<v1.length){
                num1 = Integer.parseInt(v1[i]);
            }

            if(i<v2.length){
                num2 = Integer.parseInt(v2[i]);
            }

            if(num1>num2){
                return 1;
            }else if(num1<num2) {
                return -1;
            }
        }
        return 0;
    }

    @Test
    public void my_test() {
        lc165 lc = new lc165();
        int c = lc.compareVersion("0.1", "1.1");
        System.out.println(c);
    }
}
