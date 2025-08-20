// M03_TopKConvenience.java
import java.util.*;

public class M03_TopKConvenience {
    static class Item {
        String name; int qty;
        Item(String n, int q) { name=n; qty=q; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), K = sc.nextInt();
        List<Item> list = new ArrayList<>();
        for (int i=0;i<n;i++) list.add(new Item(sc.next(), sc.nextInt()));

        PriorityQueue<Item> pq = new PriorityQueue<>(
            (a,b)-> a.qty!=b.qty? a.qty-b.qty : a.name.compareTo(b.name)
        );
        for (Item it: list) {
            pq.offer(it);
            if (pq.size()>K) pq.poll();
        }
        List<Item> ans = new ArrayList<>(pq);
        ans.sort((a,b)-> b.qty!=a.qty? b.qty-a.qty : a.name.compareTo(b.name));
        for (Item it: ans) System.out.println(it.name+" "+it.qty);
    }
}
/*
 * Time Complexity: O(n log K)
 * 說明：維護大小為K的MinHeap，每次插入O(log K)，總共O(n log K)。
 */
