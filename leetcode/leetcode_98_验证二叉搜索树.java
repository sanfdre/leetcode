package leetcode;

public class leetcode_98_验证二叉搜索树 {
    private Integer pre = null;
    private boolean isValidBST = true;
    public boolean isValidBST(TreeNode root) {
        getPre(root);
        return isValidBST;
    }

    private Integer getPre(TreeNode root){
        if(root==null) return pre;
        pre = getPre(root.left);
       if(pre!=null){
           if(pre>=root.val){
               isValidBST = false;
               return pre;
           }
       }
        pre = root.val;
        pre = getPre(root.right);
        return pre;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}