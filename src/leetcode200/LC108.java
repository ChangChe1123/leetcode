package leetcode200;

public class LC108 {
    // 将有序数组转化为平衡BST
    public TreeNode sortedArrayToBST(int[] nums){
        return generateTree(nums, 0, nums.length-1);
    }

    private TreeNode generateTree(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNod(nums[mid]);
        root.left = generateTree(nums, left, mid-1);
        root.right = generateTree(nums, mid+1, right);
        return root;
    }

}