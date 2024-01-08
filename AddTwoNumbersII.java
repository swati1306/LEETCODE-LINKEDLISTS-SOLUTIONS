Links : https://leetcode.com/problems/add-two-numbers-ii/?envType=list&envId=pwzwrhyv

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revL1=reverseList(l1);
        ListNode revL2=reverseList(l2);
        ListNode add=addTwoNumbers2(revL1, revL2);
        return reverseList(add);
    }
    public ListNode reverseList(ListNode head) {
        ListNode new_head=null;

        while(head != null){
            ListNode temp=head;
            head = head.next;
            temp.next=new_head;
            new_head=temp;
        }
        return new_head;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode temp=head;
        int carry=0;
        while(l1 != null || l2 != null || carry==1){
            int sum=0;
            if(l1 != null){
                sum=sum+l1.val;
                l1=l1.next;
            }
            if(l2 != null){
                sum=sum+l2.val;
                l2=l2.next;
            }
            //sum+carry
            sum=sum+carry;
            carry=sum/10;
            ListNode node=new ListNode(sum%10);
            temp.next=node;
            temp=temp.next;
        }
        return head.next;
    }
}