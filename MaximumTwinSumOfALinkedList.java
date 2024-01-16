Link : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=list&envId=pwzwrhyv
        Leetcode :2130. Maximum Twin Sum of a Linked List
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
    public int pairSum(ListNode head) {

        ListNode mid=findMid(head);   //step 1 find middle node
        ListNode h2=mid.next;
        mid.next=null;
        ListNode revhead=reverseList(h2); //rev second linkedlist
        int max=Integer.MIN_VALUE;

        while( revhead != null){
            max = Math.max(max, head.val + revhead.val);
            head = head.next;
            revhead= revhead.next;
        }
        return max;
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
}