
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head, fast=head;
        if(head == null){     //edge case
            return false;
        }
        while(fast.next != null && fast.next.next != null){
            //Step 1 move
            fast=fast.next.next;
            slow=slow.next;
            //Step 2 Check
            if(slow == fast){
                return true;  //cycle exists
            }
        }
        return false;   // no cycle
    }
}