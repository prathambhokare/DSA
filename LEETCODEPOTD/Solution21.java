package LEETCODEPOTD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution21 {

    public static int[] dp;

    public static Map<Integer,List<Integer>> buildGraph(int[] arr, int d) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> childNodes = new ArrayList<>();
            // right
            for (int j = i + 1; j < arr.length && j <= i + d; j++) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                childNodes.add(j);
            }
            // left
            for (int j = i - 1; j >= 0 && j >= i - d; j--) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                childNodes.add(j);
            }
            graph.put(i, childNodes);
        }
        return graph;
    }

    public static int dfs(int node, Map<Integer,List<Integer>> graph) {
        if (dp[node] != 0) {
            return dp[node];
        }
        int best = 1;
        List<Integer> children = graph.getOrDefault(node, new ArrayList<>());
        for (int next : children) {
            best = Math.max(best, 1 + dfs(next, graph));
        }
        dp[node] = best;
        return best;
    }

    public static int maxJumps(int[] arr, int d) {
        Map<Integer,List<Integer>> graph = buildGraph(arr, d);
        dp = new int[arr.length];
        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, dfs(i, graph));
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=maxJumps(new int[]{6,4,14,6,8,13,9,7,10,6,12}, 2);
        System.out.println(ans);
    }
}
