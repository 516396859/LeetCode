class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class jd4_10 {

    public boolean checkOneTree(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null){
            return true;
        }
        if((t1==null && t2!=null )||(t1!=null && t2==null )){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }else {
            return checkOneTree(t1.left,t2.left)&&checkOneTree(t1.right,t2.right);
        }
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null){
            return true;
        }
        if(t1!=null && t2==null){
            return true;
        }
        if(t1==null && t2!=null){
            return false;
        }


        boolean a = false;
        if(t1.val==t2.val){
            //根节点相同，判断左边和右边是否同一棵树
            a = checkOneTree(t1,t2);
        }

        return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2)||a;
    }
}
