import java.util.ArrayList;
import java.util.Collections;

public class lc112 {

    boolean res = false;
    public void dfs(TreeNode root, int target ,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.left==null && root.right==null){
            int sum = 0;
            for (int a : path){
                sum+=a;
            }
            if(sum==target){
                res = true;
            }
            return;
        }

        if(root.right!=null){
            dfs(root.right,target,path);
            //注意回溯
            path.remove(path.size()-1);
        }

        if (root.left!=null){
            dfs(root.left,target,path);
            //注意回溯
            path.remove(path.size()-1);
        }
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 采用递归法
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root,targetSum,path);
        return res;
    }
}
