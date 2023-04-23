import org.junit.Test;

public class lc443 {
    public int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }

        String res = "";
        int count = 1;

        for (int i = 1; i < chars.length ; i++) {
            if(chars[i]!=chars[i-1]){
                if(count!=1){
                    res += chars[i-1]+""+count;
                }else {
                    res += chars[i-1]+"";
                }
                count = 1;
            }else{
                count++;
            }
        }

        if(count==1){
            res += chars[chars.length-1];
        }else{
            res += chars[chars.length-1]+""+count;
        }

        if(chars.length>=res.length()){
            for (int i = 0; i < res.length(); i++) {
                char c = res.charAt(i);
                chars[i] = c;
            }
        }else {
            chars = res.toCharArray();
        }


        return res.length();
    }


    @Test
    public void my_test() {
        lc443 lc = new lc443();
        char[] chars = "aa".toCharArray();
        int i = lc.compress(chars);
        System.out.println(i);
    }

}
