package DSA_Refrehser;

import java.util.*;

public class Day16_Dijkstra {

    // ==========================
    // Build Graph (directed)
    // ==========================
    public static Map<Integer, List<Integer[]>> buildGraphDirected(int[][] edges) {
        Map<Integer, List<Integer[]>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];

            List<Integer[]> childNodeList =
                    graph.getOrDefault(src, new ArrayList<>());

            childNodeList.add(new Integer[]{dest, weight});
            graph.put(src, childNodeList);
        }
        return graph;
    }

    // ==========================
    // Build Graph (undirected)
    // ==========================
    public static Map<Integer, List<Integer[]>> buildGraphUndirected(int[][] edges) {
        Map<Integer, List<Integer[]>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];

            List<Integer[]> list1 = graph.getOrDefault(src, new ArrayList<>());
            list1.add(new Integer[]{dest, weight});
            graph.put(src, list1);

            List<Integer[]> list2 = graph.getOrDefault(dest, new ArrayList<>());
            list2.add(new Integer[]{src, weight});
            graph.put(dest, list2);
        }
        return graph;
    }

    // ==========================
    // 1. Dijkstra (Undirected)
    // ==========================
    public static int[] dijkstra(int V, int[][] edges, int src) {

        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);

        Map<Integer, List<Integer[]>> graph = buildGraphUndirected(edges);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[]{src, 0});
        ans[src] = 0;

        while (!pq.isEmpty()) {

            int[] parent = pq.poll();

            if (parent[1] > ans[parent[0]]) continue;

            List<Integer[]> childNodeList =
                    graph.getOrDefault(parent[0], new ArrayList<>());

            for (int i = 0; i < childNodeList.size(); i++) {

                int child = childNodeList.get(i)[0];
                int weight = childNodeList.get(i)[1];

                if (ans[parent[0]] + weight < ans[child]) {

                    ans[child] = ans[parent[0]] + weight;
                    pq.add(new int[]{child, ans[child]});
                }
            }
        }
        return ans;
    }

    // ==========================
    // 2. Network Delay Time
    // ==========================
    public static int networkDelayTime(int[][] edges, int n, int k) {

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        Map<Integer, List<Integer[]>> graph = buildGraphDirected(edges);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int src = k - 1;

        pq.add(new int[]{src, 0});
        ans[src] = 0;

        while (!pq.isEmpty()) {

            int[] parent = pq.poll();

            if (parent[1] > ans[parent[0]]) continue;

            List<Integer[]> childNodeList =
                    graph.getOrDefault(parent[0], new ArrayList<>());

            for (int i = 0; i < childNodeList.size(); i++) {

                int child = childNodeList.get(i)[0];
                int weight = childNodeList.get(i)[1];

                if (ans[parent[0]] + weight < ans[child]) {

                    ans[child] = ans[parent[0]] + weight;
                    pq.add(new int[]{child, ans[child]});
                }
            }
        }

        int ansval = -1;

        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) return -1;
            ansval = Math.max(ansval, ans[i]);
        }

        return ansval;
    }

    // ==========================
    // 3. Cheapest Price with K Stops
    // ==========================
    public static int findCheapestPrice(int n, int[][] edges,
                                        int src, int dst, int k) {

        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = Integer.MAX_VALUE;
            ans[i][1] = 0;
        }

        Map<Integer, List<Integer[]>> graph = buildGraphDirected(edges);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[]{src, 0, 0});
        ans[src][0] = 0;

        while (!pq.isEmpty()) {

            int[] parent = pq.poll();
            int node = parent[0];
            int cost = parent[1];
            int stops = parent[2];

            if (stops > k) continue;

            List<Integer[]> childNodeList =
                    graph.getOrDefault(node, new ArrayList<>());

            for (int i = 0; i < childNodeList.size(); i++) {

                int child = childNodeList.get(i)[0];
                int weight = childNodeList.get(i)[1];

                int newCost = cost + weight;

                if (newCost < ans[child][0] && stops <= k) {

                    ans[child][0] = newCost;
                    ans[child][1] = stops + 1;

                    pq.add(new int[]{child, newCost, stops + 1});
                }
            }
        }

        return ans[dst][0] == Integer.MAX_VALUE ? -1 : ans[dst][0];
    }

    // ==========================
    // MAIN METHOD (TEST CASES)
    // ==========================
    public static void main(String[] args) {

        // --------------------------
        // Dijkstra Test
        // --------------------------
        int[][] edges1 = {
                {0, 1, 4},
                {0, 2, 1},
                {2, 1, 2},
                {1, 3, 1},
                {2, 3, 5}
        };

        System.out.println("Dijkstra:");
        System.out.println(Arrays.toString(dijkstra(4, edges1, 0)));

        // --------------------------
        // Network Delay Test
        // --------------------------
        int[][] edges2 = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        System.out.println("\nNetwork Delay:");
        System.out.println(networkDelayTime(edges2, 4, 2));

        // --------------------------
        // Cheapest Flight Test
        // --------------------------
        int[][] edges3 = {
                {0, 1, 1},
                {0, 2, 5},
                {1, 2, 1},
                {2, 3, 1}
        };

        System.out.println("\nCheapest Price:");
        System.out.println(findCheapestPrice(4, edges3, 0, 3, 1));
    }
}
