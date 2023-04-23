public class lc235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || p.val==root.val || q.val==root.val){
            return root;
        }

        if(p.val > root.val && q.val<root.val){
            return root;
        }

        if(p.val < root.val && q.val > root.val){
            return root;
        }

        if(p.val > root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        if(p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }

        return null;
    }
}
