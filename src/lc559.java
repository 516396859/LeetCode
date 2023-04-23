import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node{
    List<Node> children;
}

public class lc559 {
    public int maxDepth(Node root) {
        //递归法
        if(root==null){
            return 0;
        }
        int maxx = 0;
        for (Node node : root.children){
            int temp = maxDepth(node) ;
            maxx = Math.max(maxx,temp);
        }
        return maxx+1;
    }
}
