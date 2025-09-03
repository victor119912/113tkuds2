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
    public ListNode swapPairs(ListNode head) {
        // 虛擬節點，方便處理頭節點
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // 遍歷鏈表，每次交換兩個節點
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // 交換節點
            first.next = second.next;
            second.next = first;
            current.next = second;

            // 移動 current 指針到下一對節點
            current = first;
        }

        return dummy.next; // 返回新的頭節點
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

        // 範例 1: [1,2,3,4]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        ListNode swapped1 = sol.swapPairs(head1);
        printList(swapped1); // 輸出: 2->1->4->3

        // 範例 2: []
        ListNode swapped2 = sol.swapPairs(null);
        printList(swapped2); // 輸出: (空)

        // 範例 3: [1]
        ListNode head3 = new ListNode(1);
        ListNode swapped3 = sol.swapPairs(head3);
        printList(swapped3); // 輸出: 1

        // 範例 4: [1,2,3]
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        ListNode swapped4 = sol.swapPairs(head4);
        printList(swapped4); // 輸出: 2->1->3
    }
}