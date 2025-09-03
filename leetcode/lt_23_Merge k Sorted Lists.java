/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // 優先隊列（最小堆），按節點值升序排列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        // 將每個非空鏈表的頭節點加入優先隊列
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0); // 虛擬節點
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll(); // 取出最小節點
            current.next = minNode;       // 接到結果鏈表
            current = current.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);   // 將該節點的下一個節點加入隊列
            }
        }

        return dummy.next; // 返回合併後的頭節點
    }

    // 輔助函數：打印鏈結串列
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print("->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 範例 1: [[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode merged = sol.mergeKLists(lists);
        printList(merged); // 輸出: 1->1->2->3->4->4->5->6

        // 範例 2: []
        ListNode merged2 = sol.mergeKLists(new ListNode[0]);
        printList(merged2); // 輸出: (空)

        // 範例 3: [[]]
        ListNode[] lists3 = {null};
        ListNode merged3 = sol.mergeKLists(lists3);
        printList(merged3); // 輸出: (空)
    }
}