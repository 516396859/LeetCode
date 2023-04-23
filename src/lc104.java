import java.util.ArrayDeque;

public class lc104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int depth(TreeNode root){
        if(root==null){
            return 0 ;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
    public int maxDepth(TreeNode root) {
        //两种方法 ，一种是递归法，一种是层次遍历法
        // 递归法
        //return depth(root);
        // 层次遍历
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int count = 0 ;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if(node.left!=null){
                    deque.add(node.left);
                }
                if(node.right!=null){
                    deque.add(node.right);
                }
            }
            count++;
        }
        return count;
    }
}
