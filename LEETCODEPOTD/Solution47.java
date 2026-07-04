package LEETCODEPOTD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution47 {
    public Map<Integer,List<Integer[]>> buildGraph(int[][] roads) {
        Map<Integer,List<Integer[]>> mp=new HashMap<>();
        for (int i=0;i<roads.length;i++) {
            int source=roads[i][0];
            int destination=roads[i][1];
            int cost=roads[i][2];
            List<Integer[]> childNodeList=mp.getOrDefault(source,new ArrayList<>());
            childNodeList.add(new Integer[]{destination,cost});
            mp.put(source,childNodeList);
            List<Integer[]> revChildNodeList=mp.getOrDefault(destination,new ArrayList<>());
            revChildNodeList.add(new Integer[]{source,cost});
            mp.put(destination,revChildNodeList);
        }
        return mp;
    }
    public int minimumScorePath(int parent,Map<Integer,List<Integer[]>> graph,boolean[] visited) {
        int ans=Integer.MAX_VALUE;
        if (visited[parent]) {
            return ans;
        }
        visited[parent]=true;
        List<Integer[]> childNodeList=graph.getOrDefault(parent,new ArrayList<>());
        for (int i=0;i<childNodeList.size();i++) {
            ans=Math.min(ans,
            Math.min(childNodeList.get(i)[1],minimumScorePath(childNodeList.get(i)[0],graph,visited)));
        }
        return ans;
    }
    public int minScore(int n, int[][] roads) {
        int ans=0;
        Map<Integer,List<Integer[]>> graph=buildGraph(roads);
        // for (Integer key : graph.keySet()) {
        //     System.out.print(key + " => " );
        //     List<Integer[]> childNodeList=graph.getOrDefault(key,new ArrayList<>());
        //     for (int i=0;i<childNodeList.size();i++) {
        //         System.out.print(childNodeList.get(i)[0] + " " + childNodeList.get(i)[1]);
        //     }
        //     System.out.println();
        // }
        // int[] dist=new int[n+1];
        // Arrays.fill(dist,Integer.MAX_VALUE);
        // PriorityQueue<Integer[]> pq=new PriorityQueue<>((a,b)->{
        //     return Integer.compare(a[1],b[1]);
        // });
        // pq.add(new Integer[]{1,0});
        // dist[1]=0;
        // while (!pq.isEmpty()) {
        //     Integer[] source=pq.poll();
        //     List<Integer[]> childNodeList=graph.getOrDefault(source[0],new ArrayList<>());
        //     System.out.println("Size is " + childNodeList.size());
        //     for (int i=0;i<childNodeList.size();i++) {
        //         int dest=childNodeList.get(i)[0];
        //         int cost=childNodeList.get(i)[1];
        //         System.out.println(dest + "  " + cost);
        //         if ((source[1]+cost)<dist[dest]) {
        //             pq.add(new Integer[]{dest,source[1]+cost});
        //             dist[dest]=source[1]+cost;
        //         }
        //     }
        // }
        // for (int i=0;i<dist.length;i++) {
        //     System.out.println(dist[i]);
        // }
        boolean[] visited=new boolean[n+1];
        ans=minimumScorePath(1,graph,visited);
        // return dist[n];
        return ans;
    }
}
