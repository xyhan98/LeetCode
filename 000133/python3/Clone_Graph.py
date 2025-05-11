from typing import Optional


# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        hashmap = dict()
        visit = set()

        def dfs(node: Node) -> Node:
            copy = None
            if node.val in hashmap:
                copy = hashmap[node.val]
            else:
                copy = Node(val=node.val)
                hashmap[node.val] = copy
            if node.val not in visit:
                visit.add(node.val)
                for neighbour in node.neighbors:
                    new = dfs(neighbour)
                    copy.neighbors.append(new)
            return copy
        
        if node is None:
            return None
        return dfs(node)
