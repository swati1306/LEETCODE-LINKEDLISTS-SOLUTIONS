
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
        ListNode start=head;
        while(start !=null && start.next != null){
            int temp_data=start.val;
            start.val=start.next.val;
            start.next.val=temp_data;
            start=start.next.next;
        }
        return head;
    }
}