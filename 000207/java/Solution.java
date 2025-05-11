import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Course> map = new HashMap<>();
        Set<Integer> noPrerequisites = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            Course course = new Course(i);
            map.put(course.id, course);
            noPrerequisites.add(i);
        }
        for (int[] prerequisite : prerequisites) {
            Course c1 = map.get(prerequisite[0]);
            Course c2 = map.get(prerequisite[1]);
            c2.next.add(c1);
            noPrerequisites.remove(c1.id);
        }
        if (noPrerequisites.isEmpty()) {
            return false;
        }
        Set<Integer> closed = new HashSet<>();
        List<Course> stack = new ArrayList<>(noPrerequisites.stream().map(id -> map.get(id)).toList());
        while (!stack.isEmpty()) {
            Course course = stack.remove(stack.size() - 1);
            if (closed.contains(course.id)) {
                continue;
            }
            closed.add(course.id);
            for (Course c : course.next) {
                if (course.visited.contains(c.id)) {
                    return false;
                } else {
                    if (!closed.contains(c.id)) {
                        c.visited.addAll(course.visited);
                        c.visited.add(course.id);
                        stack.add(c);
                    }
                }
            }
        }
        return closed.size() == numCourses;
    }
}

class Course {
    int id;

    List<Course> next;

    Set<Integer> visited;

    public Course(int id) {
        this.id = id;
        this.next = new ArrayList<>();
        this.visited = new HashSet<>();
    }
}