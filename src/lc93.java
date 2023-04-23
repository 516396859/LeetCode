import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class lc93 {
    @Test
    public void my_test(){
        Solution4 s = new Solution4();
        List<String> strings = s.restoreIpAddresses("1231231231234");
        System.out.println(strings);
    }
}

class Solution4 {

    public boolean isAddress(String add){
        add = add.trim();

        for(int i=0;i<add.length();i++){
            if(add.charAt(i)=='.' || Character.isDigit(add.charAt(i))){
                continue;
            }else{
                return false;
            }
        }

        String[] nums = add.split("\\.");
        for(int i=0;i<nums.length;i++){
            long num = Long.parseLong(nums[i]);
            if (num>=256 || num<0 || (nums[i].length()>1)&&nums[i].charAt(0)=='0'){
                return false;
            }
        }
        return true;
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> list = new ArrayList<String>();

        StringBuffer sb = new StringBuffer(s);
        int len = sb.length();
        for(int i=1;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j+1;k<len;k++){
                    sb.insert(i,'.');
                    sb.insert(j+1,'.');
                    sb.insert(k+2,'.');
                    String res = sb.toString();
//                    System.out.println(res);
                    if(isAddress(res)){
                        list.add(res);
                    }
                    sb = new StringBuffer(s);
                }
            }
        }
        return list;
    }
}