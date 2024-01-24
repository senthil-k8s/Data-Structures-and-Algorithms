class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int mask) {
        if (root == null) {
            return 0;
        }
        mask ^= 1 << root.val;
        if (root.left == null && root.right == null) {
            return (mask & (mask - 1)) == 0 ? 1 : 0;
        }
        int leftCount = dfs(root.left, mask);
        int rightCount = dfs(root.right, mask);
        return leftCount + rightCount;
    }
}