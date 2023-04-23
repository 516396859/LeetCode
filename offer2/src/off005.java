import java.util.HashSet;

public class off005 {

    public int maxLength(String s1,String s2){
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if(set.contains(s2.charAt(i))){
                return 0;
            }
        }
        return s1.length()*s2.length();
    }
    public int maxProduct(String[] words) {
        int maxx=0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                maxx = Math.max(maxx,maxLength(words[i],words[j]));
            }
        }
        return maxx;
    }
}
