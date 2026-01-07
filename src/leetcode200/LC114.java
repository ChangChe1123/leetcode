package leetcode200;

// 把二叉树展开成一个单链表
public class LC114 {
    // 方法1:
    // 1.检查corner case
    // 2.Tree遍历需要用到stack，定义与初值化
    // 3.更改结构时候需要prev, curr是stack pop出来的
    // 4.while-loop中，先是pop curr
    // 5.最后一步肯定是prev = curr
    // 6.第一次遍历的时候只装填，第二次遍历的时候会有个更改顺序
    // 7.更改顺序的时候，只关心prev和curr左子树的关系，右子树在stack中
    public void flatten1(TreeNode root){
        if(root == null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode curr = stack.pollLast();
            if(prev != null){
                prev.left = null;
                prev.right = curr;
            }
            if(curr.right != null){
                stack.offerLast(curr.right);
            }
            if(curr.left != null){
                stack.offerLast(curr.left);
            }
            prev = curr;
        }
    }
    // 方法2:
    // 1.找到左子树的最右叶子节点rightMost
    // 2.curr = curr.right遍历
    // 3.rightMost.right = node.right
    // 4.node.right = node.left
    // 5.node.left = null
    public void flatten2(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode rightMost = curr.left;
                while(rightMost.right != null){
                    rightMost = rightMost.right;
                }
                rightMost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    // 方法3:
    // 1.用递归代替遍历
    // 2.之前是用stack保存右子树节点
    // 3.flatten()就是排序好
    private TreeNode prev = null;
    public void flatten3(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode right = root.right;
        if(prev != null){
            prev.left = null;
            prev.right = root;
        }
        prev = root;
        flatten3(root.left);
        flatten3(right);
    }
}