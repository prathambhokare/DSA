package Graph_World;

import java.util.*;

public class TopologicalSort {

    int[] indegree;
    List<Integer>[] graph;

    @SuppressWarnings("unchecked")
    public void buildGraph(int V, int[][] edges) {

        indegree = new int[V];
        graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            graph[x].add(y);
            indegree[y]++;
        }
    }

    public void topologicalSort() {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodes = 0;
        List<Integer> topoOrder = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();
            topoOrder.add(node);
            nodes++;

            for (int neighbour : graph[node]) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (nodes == graph.length) {
            System.out.println("All Nodes Have Been Processed");
            System.out.println("Topological Order: " + topoOrder);
        } else {
            System.out.println("Cycle Detected");
        }
    }

    public static void main(String[] args) {

        TopologicalSort ts = new TopologicalSort();

        int V = 6;

        int[][] edges = {
            {5, 2},
            {5, 0},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };

        ts.buildGraph(V, edges);
        ts.topologicalSort();
    }
}