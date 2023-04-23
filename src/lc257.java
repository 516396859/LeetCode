import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc257 {
//    public List<String> binaryTreePaths(TreeNode root) {
//        //路径问题使用深度优先搜索，可以递归实现或者迭代实现
//        // 迭代法
//        ArrayList<String> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<String> paths = new Stack<>();
//        stack.add(root);
//        paths.add(root.val+"");
//
//        while(!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            String path = paths.pop();
//
//            if(node.left==null && node.right==null){
//                res.add(path);
//            }
//
//            if(node.left!=null){
//                stack.add(node.left);
//                paths.add(path+"->"+node.left.val);
//            }
//
//            if(node.right!=null){
//                stack.add(node.right);
//                paths.add(path+"->"+node.right.val);
//            }
//        }
//        return res;
//    }

//        public void treePath(TreeNode root,ArrayList<Integer> paths, ArrayList<String> res){
//            paths.add(root.val);
//            if(root.left==null && root.right==null){
//                StringBuffer sb = new StringBuffer();
//                for (int i = 0; i < paths.size() - 1; i++) {
//                    sb.append(paths.get(i)+"->");
//                }
//                sb.append(paths.get(paths.size()-1));
//                res.add(sb.toString());
//                return;
//            }
//
//            if(root.left!=null){
//                treePath(root.left,paths,res);
//                paths.remove(paths.size()-1);
//            }
//
//            if(root.right!=null){
//                treePath(root.right,paths,res);
//                paths.remove(paths.size()-1);
//            }
//        }
//        public List<String> binaryTreePaths(TreeNode root) {
//            //路径问题使用深度优先搜索，可以递归实现或者迭代实现
//            // 递归实现
//            ArrayList<String> res = new ArrayList<>();
//            ArrayList<Integer> paths = new ArrayList<>();
//            treePath(root,paths,res);
//            return res;
//        }
}
