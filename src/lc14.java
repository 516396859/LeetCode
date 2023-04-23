public class lc14 {
    public String longestCommonPrefix(String[] strs) {
        int idx = 0;

        if(strs.length==1){
            return strs[0];
        }

        while (true){
            String first = strs[0];
            for (int i = 1; i < strs.length; i++) {

                if(first.equals("") || strs[i].equals("")){
                    return "";
                }

                if(idx>=strs[i].length()||idx>=first.length()||(strs[i].charAt(idx)!=first.charAt(idx))){
                    return first.substring(0,idx);
                }
            }
            idx++;
        }
    }
}
