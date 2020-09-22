package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_序列化二叉树 {

    public static void main(String[] args) {
        leetcode_序列化二叉树 sc = new leetcode_序列化二叉树();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(sc.serialize(node1));
        TreeNode root = sc.deserialize(sc.serialize(node1));
        System.out.println(sc.serialize(node1));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        encode(root,res);
        return res.deleteCharAt(res.length() - 1).toString();
    }

    public StringBuffer encode(TreeNode root,StringBuffer str){
        if(root==null){
            str.append("N_");
        }else {
            str.append(root.val+"_");
            encode(root.left,str);
            encode(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split("_");
        Queue<String> que = new LinkedList<String>();
        for (String string : strings) {
            que.offer(string);
        }
        String val = que.poll();
        if(checkString(val)){
            TreeNode root = new TreeNode(Integer.parseInt(val));
            decode(root,que);
            return root;
        }else {
            return null;
        }
    }

    public boolean checkString(String val){
        return  !val.equals("N") && !val.equals("");
    }


    public void decode(TreeNode root,Queue<String> que){
        if(root == null)  return;
        String val = que.poll();
        TreeNode cur = null;
        if(checkString(val)){
            cur = new TreeNode(Integer.parseInt(val));
        }
        root.left = cur;
        decode(cur,que);

        val = que.poll();
        cur = null;
        if(checkString(val)){
            cur = new TreeNode(Integer.parseInt(val));
        }
        root.right = cur;
        decode(cur,que);
    }
}
