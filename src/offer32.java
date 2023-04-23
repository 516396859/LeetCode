import java.util.ArrayDeque;
import java.util.ArrayList;

public class offer32 {
    public int[] levelOrder(TreeNode root) {

        if(root==null){
            return new int[0];
        }

        ArrayList<Integer> res = new ArrayList<>();
        //层次遍历，使用队列
        ArrayDeque<TreeNode> deq = new ArrayDeque<>();
        deq.add(root);

        while(!deq.isEmpty()){
            TreeNode node = deq.pop();
            res.add(node.val);

            if(node.left!=null){
                deq.add(node.left);
            }
            if(node.right!=null){
                deq.add(node.right);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
