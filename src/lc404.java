public class lc404 {
    int sum = 0;
    public void recur(TreeNode root){
        if(root==null){
            return;
        }

        if(root.left!=null && root.left.left==null && root.left.right==null){
            //如果root.left为左叶子节点
            sum += root.left.val;
        }

        if(root.right!=null){
            recur(root.right);
        }

        if(root.left!=null){
            recur(root.left);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        recur(root);
        return sum;
    }
}
