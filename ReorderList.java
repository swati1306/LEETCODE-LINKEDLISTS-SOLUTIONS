
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
    public void reorderList(ListNode head) {

        //step 1 find middle node
        ListNode mid=findMid(head);
        ListNode h2=mid.next;
        mid.next=null;
        ListNode revhead=reverseList(h2); //rev second linkedlist

        mergeTwoLists(head,revhead);  //merge

    }
    public ListNode findMid(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode A) {
        ListNode new_head=null;

        while(A != null){
            ListNode temp=A;
            A=A.next;
            temp.next=new_head;
            new_head=temp;
        }
        return new_head;
    }
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head=null, temp=null;
        if(A== null){
            return B;
        }
        if(B == null){
            return A;
        }
        head=A;
        A=A.next;
        temp=head;

        while(A != null && B != null){

            temp.next=B;
            B=B.next;
            temp=temp.next;
            temp.next=A;
            A=A.next;
            temp=temp.next;

        }
        if(A != null){
            temp.next=A;
        }
        else{
            temp.next=B;
        }
        return head;
    }
}