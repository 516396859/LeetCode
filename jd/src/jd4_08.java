public class jd4_08 {
    boolean ppp = false;
    boolean qqq = false;
    TreeNode res ;
    public void lrc(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return;
        }
        System.out.println();
        //左右中遍历
        lrc(root.left,p,q);
        lrc(root.right,p,q);
        if(root.val==p.val){
            ppp = true;
        }
        if(root.val==q.val){
            qqq = true;
        }
        if(ppp&&qqq){
            res = root;
            return;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lrc(root,p,q);
        return res;
    }



}
