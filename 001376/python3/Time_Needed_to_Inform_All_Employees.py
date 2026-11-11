class Node:
    def __init__(self, time: int):
        self.time = time
        self.subordinates = list()

class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: list[int], informTime: list[int]) -> int:
        id2EmployeeMap = {i: Node(informTime[i]) for i in range(n)}
        for i, m in enumerate(manager):
            if m == -1:
                continue
            id2EmployeeMap[m].subordinates.append(id2EmployeeMap[i])

        def dfs(node: Node) -> int:
            t = 0
            for c in node.subordinates:
                t = max(t, dfs(c))
            return node.time + t

        return dfs(id2EmployeeMap[headID])