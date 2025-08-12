import java.util.*;

public class SlidingWindowMedian {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            if (i >= k) remove(nums[i - k]);
            if (i >= k - 1) {
                result[i - k + 1] = getMedian();
            }
        }
        return result;
    }

    private void add(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) maxHeap.offer(num);
        else minHeap.offer(num);
        balance();
    }

    private void remove(int num) {
        if (num <= maxHeap.peek()) maxHeap.remove(num);
        else minHeap.remove(num);
        balance();
    }

    private void balance() {
        while (maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
        while (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }

    private double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(swm.medianSlidingWindow(nums, 3)));
    }
}
