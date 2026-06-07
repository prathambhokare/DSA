package LEETCODEPOTD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class Solution33 {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,List<Integer[]>> mp=new HashMap<>();
        Set<Integer> childnodeset=new HashSet<>();
        for (int i=0;i<descriptions.length;i++) {
            int parent=descriptions[i][0];
            int child=descriptions[i][1];
            int direction=descriptions[i][2];
            List<Integer[]> childNodeList=mp.getOrDefault(parent,
            new ArrayList<>());
            childNodeList.add(new Integer[]{child,direction});
            mp.put(parent,childNodeList);
            childnodeset.add(child);
        }
        int parentNode=0;
        for (int key:mp.keySet()) {
            if (!childnodeset.contains(key)) {
                parentNode=key;
                break;
            }
        }
        TreeNode root=new TreeNode(parentNode);
        Queue<TreeNode> queue=new LinkedList<>();
        // for (int key:mp.keySet()) {
        //     System.out.print(key + " => ");
        //     List<Integer[]> childNodesList=mp.getOrDefault(key,new ArrayList<>());
        //     for (int i=0;i<childNodesList.size();i++) {
        //         System.out.print(childNodesList.get(i)[0] + " ");
        //     }
        //     System.out.println();
        // }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode parent=queue.poll();
            List<Integer[]> childNodeList=mp.getOrDefault(parent.val,new ArrayList<>());
            // System.out.println(childNodeList);
            if (!childNodeList.isEmpty()) {
                for (int i=0;i<childNodeList.size();i++) {
                    TreeNode child=new TreeNode(childNodeList.get(i)[0]);
                    if (childNodeList.get(i)[1]==1) {
                        parent.left=child;
                    }
                    else {
                        parent.right=child;
                    }
                    queue.add(child);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}
