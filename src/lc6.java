import org.junit.Test;

public class lc6 {
    public String convert(String s, int numRows) {
        char[][] arr = new char[1001][1001];
        String res = "";
        int length = s.length();
        int p = 0;

        int i = 0;
        int j = 0;
        arr[i][j] = s.charAt(p);

        for(int m=0;m<=length;m++){
            for(int n=0;n<(numRows-1);n++){
                if(m%2==0){
                    //偶数列
                    i++;
                    p++;
                    if(p>=s.length()){
                        break;
                    }
                    arr[i][j] = s.charAt(p);
                }else{
                    //奇数列
                    i--;
                    j++;
                    p++;
                    if(p>=s.length()){
                        break;
                    }
                    arr[i][j] = s.charAt(p);
                }
            }
        }

        for(int m=0;m<=numRows;m++){
            for(int n=0;n<=length;n++){
                if(arr[m][n]=='\u0000'){
                    continue;
                }else{
                    res+=(arr[m][n]);
                }
            }
        }
        return res;
    }

    @Test
    public void my_test(){
        lc6 l = new lc6();
        String res = l.convert("PAYPALISHIRING", 3);
        System.out.println(res);
    }
}
