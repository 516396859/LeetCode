import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class lc547 {

    class UnionFind {
        private Map<Integer,Integer> father;
        public UnionFind() {
            father = new HashMap<Integer,Integer>();
        }
        public void add(int x) {
            if (!father.containsKey(x)) {
                father.put(x, null);
            }
        }

        public void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY){
                father.put(rootX,rootY);
            }
        }

        public int find(int x) {
            int root = x;

            while(father.get(root) != null){
                root = father.get(root);
            }

            while(x != root){
                int original_father = father.get(x);
                father.put(x,root);
                x = original_father;
            }

            return root;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind();
        for(int i = 0;i < isConnected.length;i++){
            uf.add(i);
            for(int j = 0;j < i;j++){
                if(isConnected[i][j] == 1){
                    uf.merge(i,j);
                }
            }
        }
        int count=0;
        Map<Integer, Integer> father = uf.father;
        Set<Map.Entry<Integer, Integer>> entries = father.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue()==null){
                count++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        lc547 lc = new lc547();
        int circleNum = lc.findCircleNum(new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 0, 1}});
        System.out.println(circleNum);
    }

}
