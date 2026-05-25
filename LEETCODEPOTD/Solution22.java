package LEETCODEPOTD;

import java.util.LinkedList;
import java.util.Queue;

public class Solution22 {

    // Map<Integer,Boolean> ansMap=new HashMap<>();
    // public boolean canReachToEnd(int i,String s,int minJump,int maxJump) {
    //     if (i>s.length()) {
    //         return false;
    //     }
    //     if (i==s.length()-1) {
    //         return true;
    //     }
    //     if (ansMap.containsKey(i)) {
    //         return ansMap.get(i);
    //     }
    //     for (int j=i+minJump;j<=Math.min(i+maxJump,s.length()-1);j++) {
    //         if (s.charAt(j)=='0') {
    //             if (canReachToEnd(j, s, minJump, maxJump)) {
    //                 ansMap.put(i, true);
    //                 return true;
    //             }
    //         }
    //     }
    //     ansMap.put(i,false);
    //     return false;
    // }
    // public boolean canReach(String s, int minJump, int maxJump) {
    //     return canReachToEnd(0,s,minJump,maxJump);
    // }
    public static boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        //__prevent re-scanning of already visited indices
        int farthest = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (i == s.length() - 1) {
                return true;
            }
            int start = Math.max(i + minJump, farthest + 1);
            int end = Math.min(i + maxJump, s.length() - 1);
            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    queue.offer(j);
                }
            }
            farthest = i + maxJump;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean ans=canReach("011010",2,3);
        System.out.println(ans);
    }
}
