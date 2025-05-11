public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            this.repairNode(root.right, root.left);
            return root.right;
        }
        if (root.val < key) {
            root.right = this.deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = this.deleteNode(root.left, key);
        }
        return root;
    }

    private void repairNode(TreeNode node, TreeNode child) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        node.left = child;
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
