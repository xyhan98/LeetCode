from typing import Optional


class Node:
    def __init__(self, val: int):
        self.val = val
        self.children = list()
        self.d = -1

class Solution:
    def weightedSum(self, parent: list[int], nums: list[int]) -> int:
        n = len(parent)
        label2nodeMap = {i: Node(nums[i]) for i in range(n)}
        for i, p in enumerate(parent[1:], 1):
            label2nodeMap[p].children.append(label2nodeMap[i])
        stack = [label2nodeMap[0]]
        h = 1
        while len(stack) > 0:
            nodes = list()
            for node in stack:
                node.d = h
                nodes.extend(node.children)
            stack = nodes
            h += 1

        def dfs(node: Optional[Node], h: int) -> int:
            if node is None:
                return 0
            result = node.val * (h - node.d + 1)
            for n in node.children:
                result += dfs(n, h)
            return result

        return dfs(label2nodeMap[0], h - 1)
