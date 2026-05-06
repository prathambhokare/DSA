import java.util.*;

import org.w3c.dom.Node;

public class Solution9 {
    
    public boolean ans=false;
    
    public boolean isSimilar(Node root1,Node root2) {
        
        if (root1==null && root2==null) {
            return true;
        }
        if (root1==null && root2!=null) {
            return false;
        }
        if (root1!=null && root2==null) {
            return false;
        }
        if (root1.data!=root2.data) {
            return false;
        }
        
        return isSimilar(root1.left,root2.left) 
                && isSimilar(root1.right,root2.right);
    }
    
    public void checkIfSubtree(Node root1,Node root2) {
        
        if (root1==null) {
            return;
        }
        if (root1.data==root2.data) {
            if (isSimilar(root1,root2)) {
                ans=true;
                return;
            }
        }
        checkIfSubtree(root1.left,root2);
        checkIfSubtree(root1.right,root2);
        return;
    }
    public boolean isSubTree(Node root1, Node root2) {
        // code here 
        checkIfSubtree(root1,root2);
        return ans;
    }

    public static void main(String[] args) {
        isSubTree(root1,root2);
    }
}
