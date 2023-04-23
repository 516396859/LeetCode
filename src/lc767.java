import org.junit.Test;

public class lc767 {

    public char get_char(char a,int[] arr){
        int max = 0;
        char c = 'a';

        for (int i = 0; i < 26; i++) {
            if(arr[i]>max && (char)(i+'a')!=a){
                c = (char) (i+'a');
                max = arr[i];
            }
        }

        return c;
    }

    public String reorganizeString(String s) {
        int[] arr = new int[26];
        int length = s.length();
        String res="";
        int max = 0;
        int maxidx = 0;
        int other = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            arr[c-'a'] ++;

            if(arr[c-'a']>max){
                max = arr[c-'a'];
                maxidx = c-'a';
            }
        }

        for (int i = 0; i < 26; i++) {
            if(i!=maxidx){
                other += arr[i];
            }
        }

        if(other<(max-1)){
            return "";
        }
        char c = '1';
        while (res.length()<length){
            c = get_char(c,arr);
            arr[c-'a']--;
            res+=c;
        }
        return res;
    }

    @Test
    public void my_test(){
        /*
        * 思路：每次取出现次数最多的字符，
        * 但是又不能和前一个相同，
        * 如果相同取出现次数第二多的字符，
        * 直到字符全部取完
        * */
        lc767 lc = new lc767();
        String res = lc.reorganizeString("aaab");
        System.out.println(res);
    }
}

