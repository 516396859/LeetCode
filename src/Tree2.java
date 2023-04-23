import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree2 {
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

//    class Solution{
//        //前序递归，中左右
//        public List<Integer> preorderTraversal(TreeNode root){
//            ArrayList<Integer> result = new ArrayList<>();
//            preorder(root,result); // 前序遍历
//            inorder(root,result); //中序遍历
//            postorder(root,result); //后序遍历
//            return result;
//        }
//
//        public void preorder(TreeNode root, List<Integer> result){
//            if(root==null){
//                return;
//            }
//            result.add(root.val);
//            preorder(root.left,result);
//            preorder(root.right,result);
//        }
//
//        public void inorder(TreeNode root , List<Integer> result){
//            if(root==null){
//                return;
//            }
//            inorder(root.left,result);
//            result.add(root.val);
//            inorder(root.right,result);
//        }
//
//        public void postorder(TreeNode root, List<Integer> result){
//            if(root==null){
//                return;
//            }
//            postorder(root.left,result);
//            postorder(root.right,result);
//            result.add(root.val);
//        }
//    }

//    class Solution {
//        public List<Integer> preorderTraversal(TreeNode root) {
//            // 前序遍历
//            List<Integer> result = new ArrayList<>();
//            if (root == null) {
//                return result;
//            }
//            Stack<TreeNode> stack = new Stack<>();
//            while (!stack.isEmpty()) {
//                TreeNode node = stack.pop();
//                result.add(node.val);
//
//                if (root.right != null) {
//                    stack.add(root.right);
//                }
//
//                if (root.left != null) {
//                    stack.add(root.left);
//                }
//            }
//            return result;
//        }
//
//        public List<Integer> postorderTraversal(TreeNode root) {
//            // 后序遍历
//            List<Integer> result = new ArrayList<>();
//            if (root == null) {
//                return result;
//            }
//            Stack<TreeNode> stack = new Stack<>();
//            while (!stack.isEmpty()) {
//                TreeNode node = stack.pop();
//                result.add(node.val);
//
//                if (root.left != null) {
//                    stack.add(root.left);
//                }
//
//                if (root.right != null) {
//                    stack.add(root.right);
//                }
//            }
//            return result;
//        }
//    }

    public List<ArrayList<Integer>> levelOrder(TreeNode root){
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        queue.addLast(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                layer.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(layer);
        }
        return result;
    }

}
