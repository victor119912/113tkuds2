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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用虛擬節點，方便刪除頭節點
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // 先讓 first 指針走 n + 1 步，保持 first 和 second 之間間隔 n
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // 同時移動 first 和 second，直到 first 到達鏈表末尾
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // 刪除倒數第 n 個節點
        second.next = second.next.next;

        // 回傳新的頭節點
        return dummy.next;
    }
    
    // 輔助函數：打印鏈結串列（測試用）
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

        // 範例 1: [1,2,3,4,5], n = 2
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode newHead1 = sol.removeNthFromEnd(head1, 2);
        printList(newHead1); // 輸出: 1->2->3->5

        // 範例 2: [1], n = 1
        ListNode head2 = new ListNode(1);
        ListNode newHead2 = sol.removeNthFromEnd(head2, 1);
        printList(newHead2); // 輸出: (空)

        // 範例 3: [1,2], n = 1
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        ListNode newHead3 = sol.removeNthFromEnd(head3, 1);
        printList(newHead3); // 輸出: 1
    }
}