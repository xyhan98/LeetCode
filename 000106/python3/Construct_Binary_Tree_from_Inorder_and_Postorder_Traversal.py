from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder:
            return None
        i = inorder.index(postorder[-1])
        l = self.buildTree(inorder[:i], postorder[:i])
        r = self.buildTree(inorder[i+1:], postorder[i:-1])
        return TreeNode(postorder[-1], l, r)
