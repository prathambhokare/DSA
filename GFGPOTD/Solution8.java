import java.util.*;

public class Solution8 {
   
    public int runDfs(Node root) {
        
        if (root==null) {
            return 0;
        }
        
        return 1 + runDfs(root.left)
                 + runDfs(root.right);
    }
    public int getSize(Node root) {
        // code here
        int ans=0;
        ans=runDfs(root);
        return ans;
    }
    
    public static void main(String[] args) {
        int ans=runDfs(root);
        System.out.println(ans);
    }
}
