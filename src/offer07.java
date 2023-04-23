//public class offer07 {
//
//    public TreeNode build(int[] preorder, int[] inorder, int pre_l, int in_l, int in_r) {
//        TreeNode root = new TreeNode(preorder[pre_l]);
//
//        int idx = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if(inorder[i]==preorder[pre_l]){
//                idx = i;
//                break;
//            }
//        }
//        root.left = build(preorder,inorder,pre_l+1,)
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return build(preorder, inorder, 0, 0, inorder.length - 1);
//    }
//
//
