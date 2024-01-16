Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=list&envId=pwzwrhyv
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
    public ListNode deleteMiddle(ListNode head) {
        //edge cases
        if(head == null || head.next == null){
            return null;
        }
        ListNode mid =findMid(head);
        ListNode p1=head;
        while(p1.next != mid)
        {
            p1=p1.next;
        }
        p1.next=mid.next;
        return head;
    }
    public ListNode findMid(ListNode head){
        ListNode slow=head, fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}