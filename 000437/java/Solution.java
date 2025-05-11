import java.util.ArrayList;
import java.util.List;

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

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        List<Long> stack = new ArrayList<>();
        return (int) dfs(root, stack, targetSum);
    }

    private long dfs(TreeNode root, List<Long> stack, int targetSum) {
        if (root == null) {
            return 0;
        }
        long c = 0;
        stack.add(Long.valueOf(root.val));
        long sum = stack.stream().reduce(0L, (a, b) -> a + b);
        if (sum == targetSum) {
            c++;
        }
        for (int i = 0; i < stack.size() - 1; i++) {
            sum -= stack.get(i);
            if (sum == targetSum) {
                c++;
            }
        }
        long lc = dfs(root.left, stack, targetSum);
        long rc = dfs(root.right, stack, targetSum);
        stack.remove(stack.size() - 1);
        return c + lc + rc;
    }
}