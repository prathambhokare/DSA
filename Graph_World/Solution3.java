package Graph_World;

import java.util.*;

public class Solution3 {

    // Prim's Algorithm
    static class Solution {

        public int spanningTree(int V, int[][] edges) {

            List<List<int[]>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                adj.get(u).add(new int[]{v, wt});
                adj.get(v).add(new int[]{u, wt});
            }

            PriorityQueue<int[]> pq =
                    new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

            boolean[] visited = new boolean[V];

            pq.offer(new int[]{0, 0});

            int mstWeight = 0;

            while (!pq.isEmpty()) {

                int[] curr = pq.poll();

                int node = curr[0];
                int wt = curr[1];

                if (visited[node]) {
                    continue;
                }

                visited[node] = true;
                mstWeight += wt;

                for (int[] neighbour : adj.get(node)) {

                    int nextNode = neighbour[0];
                    int nextWt = neighbour[1];

                    if (!visited[nextNode]) {
                        pq.offer(new int[]{nextNode, nextWt});
                    }
                }
            }

            return mstWeight;
        }
    }

    // Kruskal's Algorithm
    static class Solution2 {

        static class DisjointSet {

            int[] parent;
            int[] rank;

            DisjointSet(int n) {
                parent = new int[n];
                rank = new int[n];

                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int find(int node) {
                if (parent[node] == node) {
                    return node;
                }

                return parent[node] = find(parent[node]);
            }

            void union(int u, int v) {

                int pu = find(u);
                int pv = find(v);

                if (pu == pv) {
                    return;
                }

                if (rank[pu] < rank[pv]) {
                    parent[pu] = pv;
                } else if (rank[pv] < rank[pu]) {
                    parent[pv] = pu;
                } else {
                    parent[pv] = pu;
                    rank[pu]++;
                }
            }
        }

        public int kruskalsMST(int V, int[][] edges) {

            Arrays.sort(edges, (a, b) ->
                    Integer.compare(a[2], b[2]));

            DisjointSet ds = new DisjointSet(V);

            int mstWeight = 0;

            for (int[] edge : edges) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (ds.find(u) != ds.find(v)) {
                    ds.union(u, v);
                    mstWeight += wt;
                }
            }

            return mstWeight;
        }
    }

    public static void main(String[] args) {

        int V = 4;

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 6},
                {0, 3, 5},
                {1, 3, 15},
                {2, 3, 4}
        };

        Solution prim = new Solution();
        Solution2 kruskal = new Solution2();

        int primAns = prim.spanningTree(V, edges);
        int kruskalAns = kruskal.kruskalsMST(V, edges);

        System.out.println("Prim MST Weight    : " + primAns);
        System.out.println("Kruskal MST Weight : " + kruskalAns);

        /*
              10
          0 ------ 1
          | \      |
        6 |  \5    |15
          |   \    |
          2----\---3
              4

          MST:
          (2,3)=4
          (0,3)=5
          (0,1)=10

          Total = 19
        */
    }
}
