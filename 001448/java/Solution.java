public class Solution {
    public int goodNodes(TreeNode root) {
        return this.dfs(root, root.val);
    }

    private int dfs(TreeNode node, int val) {
        int l = 0;
        int r = 0;
        if (node.left != null) {
            l += this.dfs(node.left, Math.max(val, node.val));
        }
        if (node.right != null) {
            r += this.dfs(node.right, Math.max(val, node.val));
        }
        return (node.val >= val ? 1 : 0) + l + r;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
