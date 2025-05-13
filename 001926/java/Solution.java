import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<Cell> heap = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.visited.size() - o2.visited.size();
            }
        });
        Cell cell = new Cell(entrance[0], entrance[1]);
        heap.add(cell);
        Set<String> visited = new HashSet<>();
        visited.add(cell.toString());
        while (!heap.isEmpty()) {
            Cell c = heap.poll();
            if ((c.row == 0 || c.row == m - 1 || c.col == 0 || c.col == n - 1)
                    && (c.row != entrance[0] || c.col != entrance[1])) {
                return c.visited.size();
            }
            for (int[] direction : directions) {
                int dr = direction[0];
                int dc = direction[1];
                int row = c.row + dr;
                int col = c.col + dc;
                if (row < 0 || row == m || col < 0 || col == n ||
                        maze[row][col] == '+' || c.visited.contains(row + "," + col)) {
                    continue;
                } else {
                    Cell next = new Cell(row, col);
                    next.visited.addAll(c.visited);
                    next.visited.add(c.toString());
                    if (!visited.contains(next.toString())) {
                        heap.add(next);
                        visited.add(next.toString());
                    }
                }
            }
        }
        return -1;
    }
}

class Cell {
    int row;
    int col;
    Set<String> visited;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.visited = new HashSet<>();
    }

    @Override
    public String toString() {
        return "" + row + "," + col;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Cell cell = (Cell) o;
        return row == cell.row && col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}