import org.junit.Test;

public class lc481 {
    public int magicalString(int n) {
        StringBuffer sb = new StringBuffer("122");
        int start = 2;
        while (sb.length()<n){
            char c = sb.charAt(start);
            char s = sb.charAt(sb.length()-1);
            if(c=='1' && s=='1'){
                sb.append('2');
            }else if(c=='1' && s=='2'){
                sb.append("1");
            }else if(c=='2' && s=='1'){
                sb.append("22");
            }else if(c=='2' && s=='2'){
                sb.append("11");
            }
            start += 1 ;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(sb.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

    @Test
    public void my_test() {
        lc481 lc = new lc481();
        int i = lc.magicalString(7);
        System.out.println(i);
    }
}
