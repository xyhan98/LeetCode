import java.util.LinkedList;

class RecentCounter {
    LinkedList<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (queue.size() > 0) {
            Integer first = queue.getFirst();
            if (first + 3000 < t) {
                queue.removeFirst();
            } else {
                break;
            }
        }
        queue.add(t);
        return queue.size();
    }
}