package Graph_World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2 {
    

    // ==========================
    // DIJKSTRA
    // ==========================

    public static Map<Integer,List<Integer[]>> buildGraph(int[][] edges) {

        Map<Integer,List<Integer[]>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {

            int parent = edges[i][0];
            int child = edges[i][1];
            int weight = edges[i][2];

            List<Integer[]> nodeList =
                    graph.getOrDefault(parent,new ArrayList<>());

            nodeList.add(new Integer[]{child,weight});

            graph.put(parent,nodeList);

            List<Integer[]> revNodeList =
                    graph.getOrDefault(child,new ArrayList<>());

            revNodeList.add(new Integer[]{parent,weight});

            graph.put(child,revNodeList);
        }

        return graph;
    }

    public static int[] dijkstra(int V,int[][] edges,int src) {

        int[] ans = new int[V];

        Arrays.fill(ans,Integer.MAX_VALUE);

        ans[src] = 0;

        Map<Integer,List<Integer[]>> graph = buildGraph(edges);

        PriorityQueue<Integer[]> pq =
                new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.add(new Integer[]{src,0});

        while (!pq.isEmpty()) {

            Integer[] parent = pq.poll();

            if (parent[1] > ans[parent[0]]) {
                continue;
            }

            List<Integer[]> children =
                    graph.getOrDefault(parent[0],new ArrayList<>());

            for (int i = 0; i < children.size(); i++) {

                int node = children.get(i)[0];
                int weight = children.get(i)[1];

                if ((parent[1] + weight) < ans[node]) {

                    ans[node] = parent[1] + weight;

                    pq.add(
                            new Integer[]{
                                    node,
                                    parent[1] + weight
                            }
                    );
                }
            }
        }

        return ans;
    }

    // ==========================
    // BELLMAN FORD
    // ==========================

    public static int[] bellmanFord(int V,int[][] edges,int src) {

        int[] ans = new int[V];

        Arrays.fill(ans,(int)1e8);

        ans[src] = 0;

        for (int i = 0; i < V - 1; i++) {

            for (int j = 0; j < edges.length; j++) {

                int parent = edges[j][0];
                int child = edges[j][1];
                int weight = edges[j][2];

                if (ans[parent] != (int)1e8 &&
                        ans[parent] + weight < ans[child]) {

                    ans[child] = ans[parent] + weight;
                }
            }
        }

        // Negative Cycle Check

        for (int j = 0; j < edges.length; j++) {

            int parent = edges[j][0];
            int child = edges[j][1];
            int weight = edges[j][2];

            if (ans[parent] != (int)1e8 &&
                    ans[parent] + weight < ans[child]) {

                return new int[]{-1};
            }
        }

        return ans;
    }

    // ==========================
    // FLOYD WARSHALL
    // ==========================

    public static void floydWarshall(int[][] dist) {

        for (int k = 0; k < dist.length; k++) {

            for (int i = 0; i < dist.length; i++) {

                for (int j = 0; j < dist.length; j++) {

                    if (dist[i][k] != (int)1e8 &&
                            dist[k][j] != (int)1e8) {

                        if (dist[i][j] >
                                dist[i][k] + dist[k][j]) {

                            dist[i][j] =
                                    dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {

            if (dist[i][i] < 0) {

                System.out.println(
                        "Negative Cycle Exists"
                );

                return;
            }
        }
    }

    // ==========================
    // HELPERS
    // ==========================

    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // ==========================
    // MAIN
    // ==========================

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
    
    public static void main(String[] args) {
                System.out.println("===== DIJKSTRA =====");

        int[][] dijkstraEdges = {
                {0,1,4},
                {0,2,1},
                {2,1,2},
                {1,3,1},
                {2,3,5}
        };

        printArray(
                dijkstra(
                        4,
                        dijkstraEdges,
                        0
                )
        );

        // Expected:
        // 0 3 1 4


        System.out.println();
        System.out.println("===== BELLMAN FORD =====");

        int[][] bellmanEdges = {
                {0,1,4},
                {0,2,5},
                {1,2,-2},
                {2,3,3}
        };

        printArray(
                bellmanFord(
                        4,
                        bellmanEdges,
                        0
                )
        );

        // Expected:
        // 0 4 2 5


        System.out.println();
        System.out.println("===== NEGATIVE CYCLE =====");

        int[][] negativeCycleEdges = {
                {0,1,1},
                {1,2,-1},
                {2,3,-1},
                {3,1,-1}
        };

        printArray(
                bellmanFord(
                        4,
                        negativeCycleEdges,
                        0
                )
        );

        // Expected:
        // -1


        System.out.println();
        System.out.println("===== FLOYD WARSHALL =====");

        int INF = (int)1e8;

        int[][] matrix = {
                {0,3,INF,7},
                {8,0,2,INF},
                {5,INF,0,1},
                {2,INF,INF,0}
        };

        floydWarshall(matrix);

        printMatrix(matrix);

        // Expected:
        // 0 3 5 6
        // 5 0 2 3
        // 3 6 0 1
        // 2 5 7 0
    }
}
