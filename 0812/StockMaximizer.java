import java.util.PriorityQueue;

public class StockMaximizer {
    public static int maxProfit(int[] prices, int k) {
        PriorityQueue<Integer> profits = new PriorityQueue<>();
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profits.offer(diff);
                if (profits.size() > k) profits.poll();
            }
        }
        int sum = 0;
        for (int p : profits) sum += p;
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(prices, 2)); // 7
    }
}
