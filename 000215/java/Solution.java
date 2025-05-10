import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            heap.add(-num);
        }
        int num = 0;
        while (k > 0) {
            num = heap.poll();
            k--;
        }
        return -num;
    }
}