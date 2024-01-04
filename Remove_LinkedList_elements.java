
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode nn=new ListNode(0);
        ListNode  tn=nn;
        //edge cases
        if (head == null)
            return null;

        while(head != null){
            if(head.val != val){
                tn.next=head;
                tn=tn.next;
                head=head.next;
            }
            else{
                head=head.next;
            }

        }
        tn.next=null;
        return nn.next;
    }
}