package LEETCODEPOTD;

import java.util.*;

public class Solution16 {

    public static Map<Integer,List<Integer>> buildGraph(int[] arr) {
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            List<Integer> childNodeList=new ArrayList<>();
            childNodeList.add(i+arr[i]);
            childNodeList.add(i-arr[i]);
            mp.put(i, childNodeList);
        }
        return mp;
    }

    public static boolean canJump(int[] arr,int start) {
        boolean ans=false;
        Map<Integer,List<Integer>> mp=buildGraph(arr);
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int parent=queue.poll();
            visited.add(parent);
            List<Integer> childNodeList=mp.getOrDefault(parent, new ArrayList<>());
            for (int i=0;i<childNodeList.size();i++) {
                if (childNodeList.get(i)==0) {
                    ans=true;
                    return ans;
                }
                if (!visited.contains(childNodeList.get(i))) {
                    queue.add(childNodeList.get(i));
                }
            }
        }
        return ans;    
    }

    public static void main(String[] args) {
        boolean ans=canJump(new int[]{1,1,1,0}, 0);
        System.out.println(ans);
    }
}
