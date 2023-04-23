import java.util.Stack;

public class lc226 {
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



    public TreeNode invertTree(TreeNode root) {
        //只需要将子节点左右反转即可
        // 前序遍历-栈实现

        if(root==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left!=null){
                stack.add(node.left);
            }

            if(node.right!=null){
                stack.add(node.right);
            }
        }
        return  root;
    }
}
