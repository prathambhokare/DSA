package LEETCODEPOTD;

import java.util.ArrayList;
import java.util.List;

public class Solution50 {
    List<Integer>[] graph;
    boolean[] visited;
    int vertices;
    int degreeSum;

    void dfs(int node) {
        visited[node] = true;
        vertices++;
        degreeSum += graph[node].size();
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        //1. find out an vertices componants  
        //2. then for each componants check if it is complete or not
        graph = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                vertices = 0;
                degreeSum = 0;
                dfs(i);
                int expectedEdges = vertices * (vertices - 1) / 2;
                int actualEdges = degreeSum / 2;
                if (expectedEdges == actualEdges) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
