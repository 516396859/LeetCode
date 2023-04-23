public class lc654 {
    public TreeNode buildTree(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int maxIdx = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIdx] );
        root.left = buildTree(nums, left, maxIdx - 1);
        root.right = buildTree(nums, maxIdx + 1, right);


        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //递归法
        TreeNode root = buildTree(nums, 0, nums.length - 1);
        return root;
    }
}
