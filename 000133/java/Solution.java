import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        List<Node> stack = new ArrayList<>();
        stack.add(node);
        Set<Integer> visited = new HashSet<>();
        visited.add(node.val);
        while (!stack.isEmpty()) {
            Node old = stack.remove(stack.size() - 1);
            Node n = map.get(old.val);
            if (n == null) {
                n = new Node(old.val);
                map.put(n.val, n);
            }
            for (Node neighbor : old.neighbors) {
                Node nei = map.get(neighbor.val);
                if (nei == null) {
                    nei = new Node(neighbor.val);
                    map.put(nei.val, nei);
                }
                n.neighbors.add(nei);
                if (!visited.contains(nei.val)) {
                    visited.add(nei.val);
                    stack.add(neighbor);
                }
            }
        }
        return map.get(1);
    }
}