import org.junit.Test;

import java.util.*;

public class DataStructure {
    @Test
    public void array1() {
        int[] arr2 = new int[]{1, 5, 13, 4, 7};
        int[] arr1 = {1, 5, 13, 4, 7};
        int res1 = Arrays.binarySearch(arr2, 13);
        boolean res2 = Arrays.equals(arr1, arr2);
        Arrays.sort(arr1);

        System.out.println(res1);
        System.out.println(res2);

        System.out.println(Arrays.toString(arr1));
        Arrays.fill(arr1,0,2,99);
        System.out.println(Arrays.toString(arr1));
    }

    @Test
    public void arrlist(){
        ArrayList<Integer> list = new ArrayList<Integer>(); //泛型要使用引用类型不能是基本数据类型，首字母大写即可提示
        list.add(1);list.add(9);list.add(3);list.add(9); list.add(2,99);//添加元素,将元素插到任意位置
        list.set(1,6); //修改下标1的元素值为6
        list.remove(3);//移除下标3的元素
        int len = list.size();
        int res = list.get(1);// 等价于a[1]

        Collections.sort(list);
        for(int i:list){
            System.out.println(i);
        }

        ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone(); //克隆一份
        list2.clear(); //清空元素
        boolean con = list.contains(3); //判断是否包含
        list.indexOf(1); //返回元素1的索引值
        boolean emp = list.isEmpty(); //判断是否为空
        Object[] arr = list.toArray(); //转换成数组
        int last = list.lastIndexOf(6); //指定元素最后出现的位置索引

        Collections.reverse(list);
        Collections.swap(list,0,1);
        System.out.println(list);

        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println("max: "+max+" min:"+min);
    }

    @Test
    public void my_stringbf(){
        StringBuffer sb = new StringBuffer();
        sb.append(123).append('c').append(737.23112).append(true).append(new char[]{'_','n','c','d'},0,3);
        // 123c737.23112true_nc
        sb.append(sb);
        // 123c737.23112true_nc123c737.23112true_nc
        System.out.println(sb);
        System.out.println(sb.capacity());
        sb.delete(0,sb.length()); //删除字符串
        System.out.println("sb:"+sb);
        sb.append("abcdefgbcdbcd");

        char c = sb.charAt(0);
        StringBuffer sb2 = sb.deleteCharAt(0);
        int first_idx = sb.indexOf("bcd");
        int second_idx = sb.indexOf("bcd",3);
        StringBuffer sb3 = sb.insert(0, "AAA");
        int last_idx = sb.lastIndexOf("bcd");
        StringBuffer sb4 = sb.replace(0, 4, "GGGGGG");
        StringBuffer rev = sb.reverse();
        sb.setCharAt(0,'A');
        CharSequence sub = sb.subSequence(3, 5);

        //Note:注意，以上sb、sb2、sb3、sb4 都指向sb内存，实际上是共享数据
    }

    @Test
    public void my_queue(){
        ArrayDeque<Integer> arrdeq = new ArrayDeque<>();
        arrdeq.add(3);
        arrdeq.add(9);
        arrdeq.add(0);

        arrdeq.addFirst(1);
        arrdeq.addLast(2);

        boolean con = arrdeq.contains(9);
        Integer peekf = arrdeq.peekFirst(); //返回队头元素
        Integer peekl = arrdeq.peekLast();//返回队尾元素

        Integer pf = arrdeq.pollFirst();//队头元素出队并返回
        Integer pl = arrdeq.pollLast();//队尾元素出队并返回

        boolean empty = arrdeq.isEmpty();
        arrdeq.clear();
    }

    @Test
    public void my_priorityQueue(){
        // 默认小根堆，如果要大根堆，只需要乘以-1即可，然后结果再恢复
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(9);
        pq.add(1);
        pq.add(4);

        Integer peek = pq.peek();
        Integer poll = pq.poll();
        boolean res = pq.remove(1);

    }

    @Test
    public void my_hash(){
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put("aaa",120);
        hash.put("bbb",110);
        hash.put("ccc",119);

        Set<String> keys = hash.keySet();
        keys.toArray();
        Collection<Integer> values = hash.values();
        hash.put("aaa",114); //可以替换成功
        hash.replace("aaa",999); //可以替换成功
        hash.remove("aaa");

    }


    @Test
    public void my_set(){
        HashSet<Integer> set = new HashSet<>();
        set.add(3);
        set.add(5);
        set.add(8);

        set.add(3);
        set.remove(3);
        boolean res = set.contains(3);
    }

    public class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(char val){
            this.val = val;
        }
    }
    
    public void my_tree(){
        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('c');
    }

    @Test
    public void string(){
        String s = "123456";
        System.out.println(s.charAt(0));

        System.out.println(s+"adf");
    }

    @Test
    public void my_treemap(){
        TreeMap<String, String> tmap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // ------按照key进行排序-------
        tmap.put("a","99");
        tmap.put("b","66");
        tmap.put("d","77");
        tmap.put("c","88");

        Iterator<String> iter = tmap.keySet().iterator();
        while (iter.hasNext()){
            String key = iter.next();
            System.out.println(key+":"+tmap.get(key));
        }

        System.out.println("---------------------");
        //------按照值进行排序---------
        Set<Map.Entry<String, String>> entries = tmap.entrySet();
        ArrayList<Map.Entry<String, String>> arr = new ArrayList<>(entries); //转成数组
        Collections.sort(arr, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                String s1 = o1.getValue();
                String s2 = o2.getValue();
                return s1.compareTo(s2);
            }
        });

        for(Map.Entry<String, String> entry:arr){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }

}
