import java.util.*;

import org.w3c.dom.Node;

public class Solution17 {
    
    public static class Node {
        int data;
        Node left;
        Node right;
    }

    public static int calculateSum(Node root) {
        if (root.left==null && root.right==null) {
            root.data=0;
            return root.data;
        }
        int leftPartSum=0;
        if (root.left!=null) {
            leftPartSum=root.left.data+calculateSum(root.left);
        }
        int rightPartSum=0;
        if (root.right!=null) {
            rightPartSum=root.right.data+calculateSum(root.right);
        }
        root.data=leftPartSum+rightPartSum;
        return root.data;
    }

    public static void toSumTree(Node root) {
        // code here
        calculateSum(root);
    }

    public static void main(String[] args) {
        int ans=toSumTree(root);
        System.out.println(ans);
    }
}
