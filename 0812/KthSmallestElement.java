import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr, 3)); // 7
    }
}
