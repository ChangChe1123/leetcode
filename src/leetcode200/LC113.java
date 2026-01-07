package leetcode200;

public class LC113 {
    // 方法1: recursion
    // 需要一个path记录每条路径的节点，需要一个result记录所有路径
    // 每一层递归，会把一个节点加到path
    // 如果是叶子节点，并且符合targetSum，把这条path记录到result
    // 如果不是叶子节点，往下递归到sub-problem
    // 来了一个node，先加到path中，处理完后会返回到上一层栈，再从path中remove
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result){
        if(node == null) return;
        path.add(node.val);
        if(node.left == null && node.right == null){
            if(node.val == targetSum){
                result.add(new ArrayList<>(path));
            }
        }else{
            dfs(node.left, targetSum-node.val, path, result);
            dfs(node.right, targetSum-node.val, path, result);
        }
        path.remove(path.size()-1);
    }

}