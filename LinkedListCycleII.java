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
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head, fast=head;
        if(head== null){
            return null;
        }
        //detect the cycle
        boolean cycle=false;
        while(fast.next != null && fast.next.next!= null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
                cycle =true;
                break;
            }
        }
        if(cycle == false){
            return null;
        }
        //find the start
        ListNode p1=head, p2=slow;
        while(p1 != p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}