from typing import Optional, Tuple


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def countDominantNodes(self, root: TreeNode | None) -> int:

        def dfs(node: Optional[TreeNode]) -> Tuple[int, int]:
            if node is None:
                return 0, 0
            lmax, lcount = dfs(node.left)
            rmax, rcount = dfs(node.right)
            _max = max(lmax, rmax, node.val)
            count = lcount + rcount + int(_max == node.val)
            return _max, count

        return dfs(root)[1]
