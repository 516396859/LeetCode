public class lc236 {

//    public boolean haveNode(TreeNode node, TreeNode p){
//        if(node==null){
//            return false;
//        }
//        if(node.val==p.val){
//            return true;
//        }
//        boolean left = false;
//        boolean right = false;
//        if(node.left!=null){
//            left = haveNode(node.left,p);
//        }
//
//        if(node.right!=null){
//            right = haveNode(node.right,p);
//        }
//        return left || right;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }

        if(left==null && right!=null){
            return right;
        }

        if(left!=null && right==null){
            return left;
        }
        return null;
    }
//        if(root.val==p.val || root.val==q.val){
//            return root;
//        }
//
//        boolean left_p = haveNode(root.left,p);
//        boolean left_q = haveNode(root.left,q);
//
//        boolean right_p = haveNode(root.right,p);
//        boolean right_q = haveNode(root.right,q);
//
//        if((left_q && right_p) || (left_p && right_q)){
//            return root;
//        }
//
//        if(left_q && left_p){
//            return lowestCommonAncestor(root.left,p,q);
//        }
//
//        if(right_q && right_p){
//            return lowestCommonAncestor(root.right,p,q);
//        }
//
//        return root;
//    }
}
