LINKS: https://leetcode.com/problems/palindrome-linked-list/?envType=list&envId=pwzwrhyv
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

    public boolean isPalindrome(ListNode head) {
        ListNode mid=findMid(head);
        ListNode head2=reverse(mid.next);
        //ListNode temp=head, temp2=head2;
        while(head != null && head2 != null){
            if(head.val != head2.val){
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;
    }
    public ListNode findMid(ListNode head){
        ListNode slow=head, fast=head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode nh=null;
        while(head != null){
            ListNode temp=head;
            head=head.next;
            temp.next=nh;
            nh=temp;
        }
        return nh;
    }
}
