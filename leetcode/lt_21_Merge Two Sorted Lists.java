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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 創建虛擬節點，方便操作
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 當兩個鏈表都不為空時
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // 接上 list1 節點
                list1 = list1.next;   // 移動 list1
            } else {
                current.next = list2; // 接上 list2 節點
                list2 = list2.next;   // 移動 list2
            }
            current = current.next;   // 移動 current
        }

        // 將剩下的節點接上（只會有一個非空）
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

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

        // 範例 1: list1 = [1,2,4], list2 = [1,3,4]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode merged = sol.mergeTwoLists(l1, l2);
        printList(merged); // 輸出: 1->1->2->3->4->4

        // 範例 2: list1 = [], list2 = []
        ListNode merged2 = sol.mergeTwoLists(null, null);
        printList(merged2); // 輸出: (空)

        // 範例 3: list1 = [], list2 = [0]
        ListNode l3 = new ListNode(0);
        ListNode merged3 = sol.mergeTwoLists(null, l3);
        printList(merged3); // 輸出: 0
    }
}