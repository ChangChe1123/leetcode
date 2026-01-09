package leetcode200;

public class LC111 {
    // 找出二叉树的最小深度
    // 方法1: 利用BFS遍历
    // BFS遍历用到queue，queue初值化，弹出加入
    // 第一个遇到的叶子节点就是depth
    public int minDepth1(TreeNode root){
        if(root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 1; i <= size; i++){
                TreeNode curr = queue.pollFirst();
                if(curr.left == null && curr.right == null){
                    return depth;
                }
                if(curr.left != null){
                    queue.offerLast(curr.left);
                }
                if(curr.right != null){
                    queue.offerLast(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }
    // 方法2: 利用递归
    // base case: null节点
    // sub-problem: 左子树/右子树为空，一般情况是左右子树都存在
    // recursion-rule: minDepth + 1
    public int minDepth2(TreeNode root){
        if(root == null) return 0;
        if(root.left == null){
            return minDepth2(root.right) + 1;
        }
        if(root.right == null){
            return minDepth2(root.left) + 1;
        }
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }
}