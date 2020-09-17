package leetcode;

import java.util.HashMap;

public class leetcode_106_从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        leetcode_106_从中序与后序遍历序列构造二叉树 leet = new leetcode_106_从中序与后序遍历序列构造二叉树();
        int[] inorder = {1,2,3,4};
        int[] postorder = {3,2,4,1};
        TreeNode root = leet.buildTree(inorder,postorder);
        System.out.println(root.val);
    }

    private HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length == 0) return null;
        map  = new HashMap(inorder.length);
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int rootIndex = map.get(root.val);
        build(inorder,postorder,0,rootIndex-1,0,rootIndex - 1,1,root);
        build(inorder,postorder,rootIndex+1,inorder.length-1,rootIndex,postorder.length-2,2,root);
        return root;
    }

    public void build(int[] inorder, int[] postorder,int inStart,int inEnd,int postStart,int postEnd,int type,TreeNode root){
        if(inEnd<inStart) return;
        if(inEnd == inStart){
            set(root,type,inorder[inStart]);
            return;
        }
        TreeNode node = set(root,type,postorder[postEnd]);
        int rootIndex= map.get(node.val);
        build(inorder,postorder,inStart,rootIndex-1,postStart,postStart+(rootIndex - 1-inStart),1,node);
        build(inorder,postorder,rootIndex+1,inEnd,postStart+(rootIndex-inStart),postEnd-1,2,node);
        return;
    }

    public TreeNode set(TreeNode root,int type,int val){
        TreeNode node = new TreeNode(val);
        if(type == 1){
            root.left = node;
        }else{
            root.right = node;
        }
        return node;
    }
}

