import java.util.ArrayList;
import java.util.Stack;

public class lc437 {
    public int pathSum(TreeNode root, int targetSum) {
        //先得到所有的路径，再前缀和法求解
        //这次使用迭代法
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        Stack<ArrayList<Integer>> paths = new Stack<>();

        stack.add(root);
        ArrayList<Integer> f = new ArrayList<>();
        f.add(root.val);
        paths.add(f);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ArrayList<Integer> path_temp = paths.pop();
            ArrayList<Integer> path = new ArrayList<>(path_temp);

            if(node.left==null && node.right==null){
                res.add(new ArrayList<>(path));
            }

            if(node.right!=null){
                stack.add(node.right);
                ArrayList<Integer> rightNewPath = new ArrayList<>(path);
                rightNewPath.add(node.right.val);
                paths.add(rightNewPath);
            }

            if(node.left!=null){
                stack.add(node.left);
                ArrayList<Integer> leftNewPath = new ArrayList<>(path);
                leftNewPath.add(node.left.val);
                paths.add(leftNewPath);
            }
        }
        
        int count = 0;
        for (int i = 0; i < res.size(); i++) {
            ArrayList<Integer> path = res.get(i);
            count += targetEqual(path,targetSum);
        }

        return count;
    }


    private int targetEqual(ArrayList<Integer> path,int target) {
        int count = 0;
        int[] B = new int[path.size()];
        B[0] = path.get(0);

        for (int i = 1; i < path.size(); i++) {
            B[i] = B[i-1]+path.get(i);
        }

        for (int i = 0; i < path.size(); i++) {
            for (int j = i; j < path.size(); j++) {
                int sum = B[j]-B[i]+path.get(i);
                if(sum==target){
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
