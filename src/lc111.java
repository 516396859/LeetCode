
class TreeNode{
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    int val ;
}

public class lc111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }

        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;

        if(root.left!=null){
            leftMin = minDepth(root.left);
        }
        if(root.right!=null){
            rightMin = minDepth(root.right);
        }

        return Math.min(leftMin,rightMin)+1;
    }
}
