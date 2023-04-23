import org.junit.Test;

import java.util.ArrayDeque;

public class lc349 {
    @Test
    public void my_test() {
        Solution2 lc = new Solution2();
        String s = lc.decodeString("3[a]");
        System.out.println(s);
    }
}


class Solution {
    String num_str = "";

    public String decodeString(String s) {
        // 此题用递归，递归三要素：传值、返回、结束条件
        // 结束条件：到底层模式即没有数字与[]，全是字母

        String res = ""; //不能定义在类中

        // 结束条件
        if (s.isEmpty()||!s.contains("[")) {
            return s;
        }

        //注意，如果是数字需要连续判断
        if (Character.isDigit(s.charAt(0))){
            num_str += s.charAt(0);
            String sub = s.substring(1,s.length());
            return decodeString(sub);
        }

        // 如果遇到[，则进行解析
        if (s.charAt(0)=='[') {
            //如果是'[':解析内部，重复n遍
            int count = 0;
            int right = 0;

            int num = Integer.parseInt(num_str);
            num_str = "";

            for(int i=0;i<s.length();i++){
                if (s.charAt(i)=='['){
                    count++;
                } else if (s.charAt(i)==']') {
                    count--;
                }
                if(count==0){
                    right = i;
                    break;
                }
            }

            String sub = s.substring(1,right);
            String last = s.substring(right+1,s.length());
            String new_str = "";
            for(int i=0;i<num;i++){
                new_str += sub;
            }
            new_str += last;
            return decodeString(new_str);

        }

        //如果首字符是字母则继续解析后面字串
        if (Character.isLetter(s.charAt(0))) {
            //如果首字符是字母
            res+=s.charAt(0);
            String sub = s.substring(1,s.length());
            String last = decodeString(sub);
            res += last;
            return res;
        }
        return s;
    }
}

class Solution2 {
    public String decodeString(String s) {
        // 建立栈
        ArrayDeque<Integer> num_stack = new ArrayDeque<Integer>();
        ArrayDeque<Character> alp_stack = new ArrayDeque<Character>();
        String num_str = "";
        StringBuffer res = new StringBuffer();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                //如果是数字，数字进栈
                num_str += c;
                continue;
            }else if(!num_str.equals("")) {
                //不是数字
                num_stack.addLast(Integer.parseInt(num_str));
                num_str = "" ;
            }


            if(c=='[' || Character.isLetter(c)){
                //如果c是字母或者 [ ，进字符栈
                alp_stack.addLast(c);
                continue;
            }
            if(c==']'){
                //如果遇见']'，则数字出栈，字符出栈直到遇见[
                String temp = "";
                String new_temp = "";
                int num = num_stack.pollLast();
                char a = alp_stack.pollLast();
                while(a!='['){
                    temp+=a;
                    a = alp_stack.pollLast();
                }
                for(int j=0;j<num;j++){
                    new_temp+=temp;
                }

                for(int j=new_temp.length()-1;j>=0;j--){
                    alp_stack.addLast(new_temp.charAt(j));
                }
            }
        }



        //弄完之后将alp_stack中的所有字母出栈即可，最后反转
        while (!alp_stack.isEmpty()){
            res.append(alp_stack.pollLast());
        }
        StringBuffer rev_res = res.reverse();

        return rev_res.toString();
    }
}

