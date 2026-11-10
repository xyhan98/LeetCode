from typing import List


class Node:
    def __init__(self, time: int):
        self.time = time
        self.childrens = list()

class Solution:
    def finishTime(self, n: int, edges: List[List[int]], baseTime: List[int]) -> int:
        task2NodeMap = {i: Node(baseTime[i]) for i in range(n)}
        for edge in edges:
            u, v = edge
            task2NodeMap[u].childrens.append(task2NodeMap[v])

        def dfs(node: Node) -> int:
            if len(node.childrens) == 0:
                return node.time
            earliest, latest = float('inf'), 0
            for child in node.childrens:
                t = dfs(child)
                earliest = min(earliest, t)
                latest = max(latest, t)
            return 2 * latest - earliest + node.time

        return dfs(task2NodeMap[0])
            