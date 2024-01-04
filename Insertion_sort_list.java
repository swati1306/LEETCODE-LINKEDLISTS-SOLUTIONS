
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
    public ListNode insertionSortList(ListNode head) {
        //using merge sort idea
        if(head== null || head.next==null){
            return head;
        }
        ListNode mid=findMid(head);
        ListNode head2=mid.next;
        mid.next=null;

        head=insertionSortList(head);
        head2=insertionSortList(head2);
        ListNode newhead=merge(head, head2);
        return newhead;
    }
    public ListNode findMid(ListNode h){
        ListNode slow=h, fast=h;
        while(fast.next != null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode head=null, temp=null;
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            head=list1;
            list1=list1.next;
        }
        else{
            head=list2;
            list2=list2.next;
        }

        temp=head;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next=list1;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1 != null){
            temp.next=list1;
        }
        else{
            temp.next=list2;
        }
        return head;
    }
}