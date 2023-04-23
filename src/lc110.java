public class lc110 {


    public int depth(TreeNode root){
        if(root==null){
            return  0 ;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }



    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(Math.abs(leftDepth-rightDepth)>1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }
}
