import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        //层次遍历，使用队列
        ArrayDeque<TreeNode> deq = new ArrayDeque<>();
        deq.add(root);
        int flag = 0;

        while(!deq.isEmpty()){

            ArrayList<Integer> temp = new ArrayList<>();
            int size = deq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deq.pop();
                temp.add(node.val);

                if(node.left!=null){
                    deq.add(node.left);
                }
                if(node.right!=null){
                    deq.add(node.right);
                }
            }

            ArrayList<Integer> rever = new ArrayList<>();
            if(flag%2==1){
                for (int j = temp.size()-1; j >=0 ; j--) {
                    rever.add(temp.get(j));
                }
            }else {
                rever = temp;
            }

            res.add(rever);
            flag += 1;
        }
        return res;
    }
}
