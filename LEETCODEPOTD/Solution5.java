package LEETCODEPOTD;

import java.util.*;

public class Solution5 {

    public static ListNode rotateRight(ListNode head, int k) {
        //__search for head Node
        int len=0;
        ListNode temp=head;
        ListNode temp1=head;
        ListNode headOld=head;
        while (temp!=null) {
            len=len+1;
            headOld=temp;
            temp=temp.next;
        }
        if (head==null || k==0 || len==1 || (k%len==0)) {
            return head;
        }
        int headPos=len-(k%len);
        ListNode prev=null;
        int i=0;
        while (temp1!=null && i!=headPos) {
            prev=temp1;
            temp1=temp1.next;
            i=i+1;
        }
        prev.next=null;
        headOld.next=head;
        return temp1;
    }
    
    public static void main(String[] args) {
        ListNode head=new ListNode();
        rotateRight(head,3);
    }
}
