
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
        int length=length(head);

        if(length == 1){
            return null;
        }

        if(n >= length){
            head = head.next;
            return head;
        }

        int pos = length - n; //5-2=3
        ListNode temp = head;
        for(int i=1;i<pos;i++){ //skip 3-1=2 iterations
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    public int length(ListNode head){
        int count=0;
        ListNode temp=head;
        while(temp != null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}