public class jd17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int mindis = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)){
                idx1 = i;
                if(idx2!=-1){
                    mindis = Math.min(mindis,i-idx2);
                }
            }

            if(words[i].equals(word2)){
                idx2 = i;
                if(idx1!=-1){
                    mindis = Math.min(mindis,i-idx1);
                }
            }
        }
        return mindis;
    }
}
