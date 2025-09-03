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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            // 檢查是否還有 k 個節點可反轉
            ListNode kth = prevGroup;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break; // 不足 k 個節點，停止

            ListNode groupStart = prevGroup.next;
            ListNode nextGroup = kth.next;

            // 反轉 k 個節點
            ListNode prev = nextGroup;
            ListNode curr = groupStart;
            while (curr != nextGroup) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // 接回上一組
            prevGroup.next = kth;
            prevGroup = groupStart; // 移到下一組的前一個節點
        }

        return dummy.next;
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

        // 範例 1: [1,2,3,4,5], k=2
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode res1 = sol.reverseKGroup(head1, 2);
        printList(res1); // 輸出: 2->1->4->3->5

        // 範例 2: [1,2,3,4,5], k=3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        ListNode res2 = sol.reverseKGroup(head2, 3);
        printList(res2); // 輸出: 3->2->1->4->5
    }
}