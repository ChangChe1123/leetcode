package leetcode200;

public class LC110 {
    // 方法1: recursion O(n2)
    public boolean isBalanced1(TreeNode root){
        if(root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced1(root.left) && isBalanced1(root.right);
    }
    private int getHeight(TreeNode node){
        if(node == null) return 0;
        int leftTreeHeight = getHeight(node.left);
        int rightTreeHeight = getHeigh(node.right);
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
    // 方法2: 优化recursion O(n)
    public isBalanced1(TreeNode root){
        return height(root) == -1 ? false : true;
    }
    private int height(TreeNode node){
        if(node == null) return 0;
        int leftHeight = height(node.left);
        if(leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if(rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}