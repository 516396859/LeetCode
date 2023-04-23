import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class lc501 {
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

    public int[] findMode(TreeNode root) {
        //二叉搜索树中序遍历有序

        ArrayList<Integer> value = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        lcr(root,value);

        for (int a : value){
//            map.put(a,map.getOrDefault(map.get(a),0)+1);
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }

        int max=Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> ent :map.entrySet()){
            max = Math.max(max,ent.getValue());
        }

        for (Map.Entry<Integer, Integer> ent :map.entrySet()){
            if(ent.getValue()==max){
                res.add(ent.getKey());
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
                arr[i] = res.get(i);
        }
        return arr;
    }
}

