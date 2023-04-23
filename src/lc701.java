public class lc701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            root = new TreeNode(val);
            return root;
        }

        if(root!=null && root.left==null && root.val>=val){
            root.left = new TreeNode(val);
        }

        if(root!=null && root.right==null && root.val<val){
            root.right = new TreeNode(val);
        }

        if(val<=root.val){
             insertIntoBST(root.left,val);
        }else {
             insertIntoBST(root.right,val);
        }

        return root;
    }
}