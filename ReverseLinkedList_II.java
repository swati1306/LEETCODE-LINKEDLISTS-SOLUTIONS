
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode leftprev=dummy;
        ListNode curr=head;
        for(int i=0;i<left-1;i++){
            leftprev=leftprev.next;
            curr=curr.next;
        }
        //mark the start
        ListNode rightend=curr;

        //reverse
        ListNode nh = null;
        for(int i=0; i<=right-left;i++){
            ListNode temp=curr.next;
            curr.next=nh;
            nh=curr;
            curr=temp;
        }
        //join the parts
        leftprev.next=nh;
        rightend.next=curr;
        return dummy.next;
    }
}