public class lc538 {

    int preNode = 0;

    public void dfs(TreeNode root ){
        // 遍历顺序：右中左
        if(root==null){
            return ;
        }

        if(root.right!=null){
            dfs(root.right);
        }

        preNode += root.val;
        root.val = preNode;

        if(root.left!=null){
            dfs(root.left );
        }
    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
}
