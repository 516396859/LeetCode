import java.util.ArrayList;

public class lc530 {

    public void lcr(TreeNode root, ArrayList<Integer> res){
        if(root==null){
            return;
        }
        if(root.left!=null){
            lcr(root.left,res);
        }
        res.add(root.val);
        if(root.right!=null){
            lcr(root.right,res);
        }
    }


    public int getMinimumDifference(TreeNode root) {
        //二叉搜索树中序遍历有序
        ArrayList<Integer> res = new ArrayList<>();
        lcr(root,res);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size() - 1; i++) {
            min = Math.max(min,Math.abs(res.get(i)-res.get(i+1)));
        }
        return min;
    }
}
