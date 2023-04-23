import java.util.*;

class Node{
    int val;
    List<Node> children;
    Node(int val){
        this.val = val;
        this.children = new ArrayList<>();
    }
}
public class Main2 {
    public static void dfs(Node node,Node parent,int[] depths, Map<String,Integer> edges){
        if(parent!=null){
            depths[node.val] = depths[parent.val]+1;
            edges.put(node.val+","+parent.val,1);
            edges.put(parent.val+","+node.val,1);
        }
        for(Node child:node.children){
            if(child!=parent){
                dfs(child,node,depths,edges);
            }
        }
    }
    public static int longesPath(Node[] tree,int[] selectedEdge){
        int n = tree.length;
        int[] depths = new int[n];
        Map<String,Integer> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges.put(i+","+j,0);
            }
        }
        dfs(tree[selectedEdge[0]],null,depths,edges);
        dfs(tree[selectedEdge[1]],null,depths,edges);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i<j && edges.get(i+","+j)==0){
                    edges.put(i+","+j,depths[i]+depths[j]-2*depths[selectedEdge[0]]);
                }
            }
        }
        int maxPath = 0;
        for (int pathLength : edges.values()){
            maxPath = Math.max(maxPath,pathLength);
        }
        return maxPath;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt()-1;
            tree[i+1].children.add(tree[v]);
            tree[v].children.add(tree[i+1]);
        }
        int[] selectedEdge = new int[2];
        selectedEdge[0] = scanner.nextInt()-1;
        selectedEdge[1] = scanner.nextInt()-1;
        System.out.println(longesPath(tree,selectedEdge));
    }
}
