import java.util.*;

import javax.management.Query;
import javax.swing.text.Segment;


public class SegmentTree {

    Node[] segmentTree;

    static class Node {
        int val;

        Node(int val) {
            this.val=val;
        }
    }

    public SegmentTree(int size) {
        this.segmentTree=new Node[size];
        for (int i=0;i<segmentTree.length;i++) {
            segmentTree[i]=new Node(0);
        }
    }

    //__Operations Build Segment Tree
    //___1. i -> represents position of element in an array
    //___2. l,r -> reprsents range hold at each node
    //_______ root node     => l=0,r=n n => is the size of array
    //_______ leaf node     => l==r, which actually hold ind. elements
    //_______ internal node => l....r hold any internal range of array
    public void buildSegmentTree(int root,int l,int r,int[] arr) {

        if (l==r) {
            segmentTree[root]=new Node(arr[r]);
            return;
        }

        int mid=(l+r)/2;
        buildSegmentTree(2*root+1, l, mid, arr);
        buildSegmentTree(2*root+2, mid+1, r, arr);
        segmentTree[root]=new Node(segmentTree[2*root+1].val + segmentTree[2*root+2].val);
    }

    //__Operations Update Segment Tree
    //___1. idx -> update value at idx 
    //___2. val -> update with given value
    //___3. root -> root node of segment tree
    //___4. l,r -> reprsents range hold at each node
    //_______ root node     => l=0,r=n n => is the size of array
    //_______ leaf node     => l==r, which actually hold ind. elements
    //_______ internal node => l....r hold any internal range of array
    public void updateSegmentTree(int idx,int val,int root,int l,int r) {

        if (l==r) {
            segmentTree[root].val=val;
            return;
        }

        int mid=(l+r)/2;
        //__check where idx lies 
        if (idx<=mid) { //__element to update is on left side
            //go to left side
            updateSegmentTree(idx, val, 2*root+1, l, mid);
        }
        else { //__element to update is on right side
            //go to right side
            updateSegmentTree(idx, val, 2*root+2, mid+1, r);
        }
        //once reached base case while returning update lastest value
        segmentTree[root].val=segmentTree[2*root+1].val+segmentTree[2*root+2].val;
    }

    //__Operations Query Segment Tree
    //___1. root -> root node of segment tree
    //___2. ql,qr -> query sum for given range [ql....qr]
    //___4. l,r -> reprsents range hold at each node
    //_______ root node     => l=0,r=n n => is the size of array
    //_______ leaf node     => l==r, which actually hold ind. elements
    //_______ internal node => l....r hold any internal range of array
    public int querySegmentTree(int root,int ql,int qr,int l,int r) {
        // Query Range     = what user wants
        // Current Segment = what current node represents

        //CASE 01: Current Range[l....r] Is Out Of Bound Of Requested Range[ql....qr]
        if (ql>r || qr<l) {
            return 0;
        }
        //CASE 02: Current[l....r] Range Is WithIn Requested Range[ql....qr]
        if (l>=ql && r<=qr) {
            return segmentTree[root].val;
        }
        int mid=(l+r)/2;
        return querySegmentTree(2*root+1,ql,qr,l,mid) + querySegmentTree(2*root+2,ql,qr,mid+1,r);
    }

    public void print(int root) {

        if (root>=segmentTree.length) return;
    
        print(2*root+1);
        print(2*root+2);
        System.out.println(root + " =>  " + segmentTree[root].val);
    }

    public static void main(String[] args) {
        System.out.println("<========= Segment Tree ==========>");
        int[] arr=new int[]{3,1,2,7};
        int size=4*arr.length;
        SegmentTree segmentTree=new SegmentTree(size);
        segmentTree.buildSegmentTree(0,0,arr.length-1,arr);
        segmentTree.print(0);
        segmentTree.updateSegmentTree(0, 4, 0, 0, arr.length-1);
        segmentTree.print(0);
        int ans=segmentTree.querySegmentTree(0, 1, 3, 0, arr.length-1);
        System.out.println(ans);
    }
}