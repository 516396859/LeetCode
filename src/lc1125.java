import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class lc1125 {
    int min = Integer.MAX_VALUE;
    ArrayList temp = new ArrayList<Integer>();
    ArrayList res;
    public boolean isValid(String[] req_skills, List<List<String>> people){
//        ArrayList<String> req = new ArrayList<String>(Arrays.asList(req_skills));
        HashSet<String> set = new HashSet<>(Arrays.asList(req_skills));
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < people.get((int)temp.get(i)).size(); j++) {
                String s = people.get((int)temp.get(i)).get(j);
//                req.remove(s);
                set.remove(s);
            }
        }
        if(set.size()==0){
            return true;
        }
        return false;
    }

    public void dfs(String[] req_skills, List<List<String>> people, int startIndex){
        if(res!=null || startIndex>people.size()){
            return;
        }

        if(isValid(req_skills,people)){
            min = temp.size();
            res = (ArrayList<Integer>)temp.clone();
            return;
        }



//        for (int i = startIndex; i < people.size(); i++) {
//            temp.add(i);
//            dfs(req_skills,people,i+1);
//            temp.remove(temp.size()-1);
//        }

        // 不取
        dfs(req_skills,people,startIndex+1);

        //取
        temp.add(startIndex);
        dfs(req_skills,people,startIndex+1);
        temp.remove(temp.size()-1);
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        //组合问题？
         dfs(req_skills,people,0);
         int[] result = new int[res.size()];
         for (int i = 0; i < res.size(); i++) {
             result[i] = (int) res.get(i);
         }
        System.out.println(min);
        return result;
    }

    @Test
    public void test(){
        lc1125 lc = new lc1125();
        List<List<String>> people = new ArrayList<>();
        List<String> pe = new ArrayList<>();
        pe.add("java");
        pe.add("node");
        people.add(pe);
        int[] ints = lc.smallestSufficientTeam(new String[]{"java"}, people);
        System.out.println(ints);
    }
}
