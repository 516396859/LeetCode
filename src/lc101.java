import java.util.ArrayDeque;
import java.util.ArrayList;

public class lc101 {

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

    public boolean compare(TreeNode left,TreeNode right){
        if(left==null && right!=null){
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if(left==null && right==null){
            return true;
        } else if (left!=null && right!=null) {
            return left.val==right.val && compare(left.left,right.right) && compare(left.right,right.left);
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        //两种解法 1、递归法:两个子树的 外侧树相等，内侧树相等  2、队列法
        if(root==null){
            return true;
        }

        return compare(root.left,root.right);
    }

    public boolean isSymmetric2(TreeNode root) {
        //2、队列法，每次进队2个节点，出队2个节点
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if(root.left==null && root.right==null){
            return true;
        } else if(root.left!=null && root.right!=null){
            deque.add(root.left);
            deque.add(root.right);
        } else {
            return false;
        }

        while (!deque.isEmpty()){
            TreeNode node1 = deque.pollFirst();
            TreeNode node2 = deque.pollFirst();
            if(node2.val!=node1.val || (node1.left!=null && node2.right==null)||(node1.left==null && node2.right!=null)
                    ||(node1.right==null && node2.left!=null)||(node1.right!=null && node2.left==null)){
                return false;
            }
            if(node1.left!=null){
                deque.add(node1.left);
                deque.add(node2.right);
            }
            if(node1.right!=null){
                deque.add(node1.right);
                deque.add(node2.left);
            }
        }
        return true;
    }
}
