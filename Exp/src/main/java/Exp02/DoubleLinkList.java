package Exp02;

public class DoubleLinkList {
    private int size;
    private Node head;
    private Node tail;

    public DoubleLinkList() {
        this.head = new Node(0,0,0);
        this.tail = new Node(0,0,0);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        size++;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeLast(){
        if (head.next==tail){
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size(){
        return size;
    }
}
