import java.util.ArrayList;
import java.util.List;

public class lc113 {
    public void dfs(TreeNode root, int target , ArrayList<Integer> path,List<List<Integer>> res){
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.left==null && root.right==null){
            int sum = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int a : path){
                sum+=a;
                temp.add(a);
            }
            if(sum==target){
                res.add(temp);
            }
            return;
        }

        if(root.right!=null){
            dfs(root.right,target,path,res);
            //注意回溯
            path.remove(path.size()-1);
        }

        if (root.left!=null){
            dfs(root.left,target,path,res);
            //注意回溯
            path.remove(path.size()-1);
        }
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 采用递归法
        ArrayList<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,targetSum,path,res);
        return res;
    }
}
