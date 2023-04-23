import java.util.HashSet;

public class lc318 {
    public int maxProduct(String[] words) {

        int res = 0;

        for (int i = 0; i < words.length; i++) {

            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }

            for (int j = i+1; j < words.length; j++) {
                int flag = 0;
                for (int k = 0; k < words[j].length(); k++) {
                    if(set.contains(words[j].charAt(k))){
                        flag = 1;
                        break;
                    }
                }
                if(flag==0){
                    res = Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
