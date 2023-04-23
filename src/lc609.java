import org.junit.Test;

import java.util.*;

public class lc609 {
    public List<List<String>> findDuplicate(String[] paths) {
        int length = paths.length;
        HashMap<String, String> map = new HashMap<>(); //路径与内容的映射
        HashSet<String> content_set = new HashSet<>(); //重复的内容
        HashSet<Object> set = new HashSet<>();
        List<List<String>> res = new ArrayList<>();


        for (int i = 0; i < length; i++) {
            String sss = paths[i];
            String[] str = sss.split(" "); //获取路径与文件
            String root = str[0];
            for(int j=1;j<str.length;j++){
                String file = str[j];
                String[] fc = file.split("\\(");
                String file_name = fc[0];
                String file_cont = fc[1];
                String path = root+"/"+file_name;

                if(set.contains(file_cont)){
                    //map已经存在该内容
                    content_set.add(file_cont);
                }
                map.put(path,file_cont);
                set.add(file_cont);
            }
        }

        Iterator<String> setiter = content_set.iterator();

        while(setiter.hasNext()){
            String content = setiter.next();
            ArrayList<String> arr = new ArrayList<>();
            Iterator<String> mapiter = map.keySet().iterator();
            while (mapiter.hasNext()){
                String path = mapiter.next();
                String cont = map.get(path);
                if(cont.equals(content)){
                    arr.add(path);
                }
            }
            res.add(arr);
        }
        return res;
    }

    @Test
    public void my_test() {
        lc609 lc = new lc609();
        String[] paths = new String[]{" "};
        List<List<String>> res = lc.findDuplicate(paths);
        System.out.println(res);
    }
}
