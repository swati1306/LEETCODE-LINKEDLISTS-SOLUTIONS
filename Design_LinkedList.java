
class Node{
    int val;
    Node next;
    public Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
}
class MyLinkedList {
    Node head=null;
    int count=0;
    public MyLinkedList() {


    }
    public int size(){
        return count;
    }

    public int get(int index) {
        if(index<=-1||index>=size()) return -1;
        Node curr=head;
        for(int i=1;i<=index;i++){
            curr=curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size(),val);
    }

    public void addAtIndex(int index, int val) {
        if(index<=-1||index>size()) return ;
        if(index==0){
            head=new Node(val,head);
            count++;
            return ;
        }
        Node curr=head;
        for(int i=1;i<index;i++){
            curr=curr.next;
        }
        curr.next=new Node(val,curr.next);
        count++;
    }

    public void deleteAtIndex(int index) {
        if(index <= -1||index >=size()) return ;
        if(index==0){
            head=head.next;
            count--;
            return;
        }
        Node curr=head;
        for(int i=1;i<index;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        count--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
