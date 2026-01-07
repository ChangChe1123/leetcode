package leetcode200;

public class LC112 {
    // 方法1: 递归
    // base case有两种：null节点，叶子节点
    // sub-problem: tree node分成左右子树
    // recursion rule: 两个子树的结果汇总
    public boolean hasPathSum1(TreeNode root, int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum1(root.left, targetSum-root.val) ||
                hasPathSum1(root.right, targetSum-root.val);
    }

    // 方法2: 遍历
    // 遍历需要用到两个stack，一个存TreeNode一个存sum
    // stack while-loop中，弹出一个加两个
    public boolean hasPathSum2(TreeNode root, int targetSum){
        if(root == null) return false;
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> sumStack = new ArrayDeque<>();

        nodeStack.offerLast(root);
        sumStack.offerLast(root.val);
        while(!nodeStack.isEmpty()){
            TreeNode curr = nodeStack.pollLast();
            int currentSum = sumStack.pollLast();
            if(curr.left == null && curr.right == null){
                if(currentSum == targetSum){
                    return true;
                }
            }
            if(curr.right != null){
                nodeStack.offerLast(curr.right);
                sumStack.offerLast(currentSum + curr.right.val);
            }
            if(curr.left != null){
                nodeStack.offerLast(curr.left);
                sumStack.offerLast(currentSum + curr.left.val);
            }
        }
        return false;
    }
}