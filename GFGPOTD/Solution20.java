import java.util.*;

import org.w3c.dom.Node;

public class Solution20 {
    
    public static void runDfs(Node root,int lineNumber,Map<Integer,Integer> mp) {
        if (root==null) {
            return;
        }
        mp.put(lineNumber,mp.getOrDefault(lineNumber,0)+root.data);
        runDfs(root.left,lineNumber-1,mp);
        runDfs(root.right,lineNumber+1,mp);
        return;
    }
    public static ArrayList<Integer> verticalSum(Node root) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        Map<Integer,Integer> mp=new TreeMap<>();
        runDfs(root,0,mp);
        for (Integer key : mp.keySet()) {
            ans.add(mp.get(key));
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ans=verticalSum(root);
        for (int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
