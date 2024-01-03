// Links: https://leetcode.com/problems/copy-list-with-random-pointer/?envType=list&envId=pwzwrhyv
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        //edge case
        if (head == null) {
            return null;
        }
        //duplicates of all the nodes
        Node temp=head;
        while(temp != null){
            Node nn = new Node(temp.val);
            nn.next=temp.next;
            temp.next=nn;
            temp=nn.next;
        }
        //create random connections
        Node t1= head;
        Node t2= head.next;
        while(t1 != null){
            if(t1.random != null){
                t2.random=t1.random.next;
            }

            t1=t2.next;
            if(t1 != null){
                t2=t1.next;
            }
        }
        Node newHead = head.next;
        t1=head;
        t2=newHead;
        while(t1 != null){
            t1.next = t2.next;
            t1 = t1.next;
            if(t1 != null){
                t2.next = t1.next;
            }
            t2 = t2.next;
        }
        return newHead;
    }
}