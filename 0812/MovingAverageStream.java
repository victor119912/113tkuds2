import java.util.*;

public class MovingAverageStream {
    private Queue<Integer> window;
    private int size;
    private double sum;
    private PriorityQueue<Integer> maxHeap, minHeap;

    public MovingAverageStream(int size) {
        this.size = size;
        window = new LinkedList<>();
        sum = 0;
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public double next(int val) {
        window.offer(val);
        sum += val;
        if (window.size() > size) {
            int removed = window.poll();
            sum -= removed;
        }
        addNumber(val);
        return sum / window.size();
    }

    private void addNumber(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) maxHeap.offer(num);
        else minHeap.offer(num);
        balanceHeaps();
    }

    private void balanceHeaps() {
        while (maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
        while (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }

    public double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public int getMin() {
        return Math.min(maxHeap.peek(), minHeap.isEmpty() ? maxHeap.peek() : minHeap.peek());
    }

    public int getMax() {
        return Math.max(maxHeap.peek(), minHeap.isEmpty() ? maxHeap.peek() : minHeap.peek());
    }

    public static void main(String[] args) {
        MovingAverageStream ma = new MovingAverageStream(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
        System.out.println(ma.getMedian());
        System.out.println(ma.getMin());
        System.out.println(ma.getMax());
    }
}
