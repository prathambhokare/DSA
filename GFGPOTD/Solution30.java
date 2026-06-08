import org.w3c.dom.Node;

public class Solution30 {
    /* Structure of linked list node
    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    */
    Node reverse(Node head) {
        Node prev=null;
        while (head!=null) {
            Node headNext=head.next;
            head.next=prev;
            prev=head;
            head=headNext;
        }
        return prev;
    }

    Node compute(Node head) {
        Node revNode=reverse(head);

        Node ans=revNode; 

        Node prev=revNode;
        revNode=revNode.next;

        int value=prev.data;

        while (revNode!=null) {
            if (revNode.data < value) { 
                prev.next=revNode.next;
                revNode=prev.next;
            }
            else {
                value=revNode.data;
                prev=revNode;
                revNode=revNode.next;
            }
        }

        return reverse(ans);
    }
}
