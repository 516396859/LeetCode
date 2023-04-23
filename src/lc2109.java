import java.util.function.BiFunction;

public class lc2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer sb = new StringBuffer(s);
        int py = 0;
        for(int i:spaces){
            sb.insert(i+py,' ');
            py++;
        }
        return sb.toString();
    }
}
