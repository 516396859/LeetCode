import java.util.ArrayList;

public class offer4_06 {
    TreeNode res = null;
    public void inorder(TreeNode root, TreeNode p , ArrayList<TreeNode> deq) {
        if (root == null) {
            return;
        }

        inorder(root.left, p,deq);
        if(!deq.isEmpty()&&deq.get(deq.size()-1).val==p.val){
            res = root;
        }
        deq.add(root);
        inorder(root.right, p,deq);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> deq = new ArrayList<>();
        inorder(root, p,deq);
        return res;
    }
}
