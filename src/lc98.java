public class lc98 {

    long prevalue = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        //要知道中序遍历下，输出的二叉搜索树节点的数值是有序序列。
        //有了这个特性，验证二叉搜索树，就相当于变成了判断一个序列是不是递增的了
        if(root==null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }

        if(root.val<prevalue){
            return false;
        }

        prevalue = (long)root.val;

        if(!isValidBST(root.right)){
            return false;
        }

        return true;
    }
}
