package Graph_World;

import java.util.*;

public class Solution1 {

    public Map<Integer, List<Integer>> graph;

    public Solution1() {
        this.graph = new HashMap<>();
    }

    public void buildUndirectedGraph(int v, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            List<Integer> nodeList = graph.getOrDefault(parent, new ArrayList<>());
            nodeList.add(child);
            graph.put(parent, nodeList);
            List<Integer> revNodeList = graph.getOrDefault(child, new ArrayList<>());
            revNodeList.add(parent);
            graph.put(child, revNodeList);
        }
    }

    public void buildGraph(int v, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            List<Integer> nodeList = graph.getOrDefault(parent, new ArrayList<>());
            nodeList.add(child);
            graph.put(parent, nodeList);
        }
    }

    public void printGraph() {
        for (int node : graph.keySet()) {
            System.out.print(node + " -> ");
            for (int i = 0; i < graph.get(node).size(); i++) {
                System.out.print(graph.get(node).get(i) + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int root, boolean[] visited) {
        System.out.println(root);
        visited[root] = true;
        List<Integer> childNodeList = graph.getOrDefault(root, new ArrayList<>());
        for (int i = 0; i < childNodeList.size(); i++) {
            if (!visited[childNodeList.get(i)]) {
                dfs(childNodeList.get(i), visited);
            }
        }
        return;
    }

    public boolean detectCycleInUndirectedGraph(int node, int parent, boolean[] visited) {

        // __mark as visited
        visited[node] = true;

        // __get all child node list
        List<Integer> childNodeList = graph.getOrDefault(node, new ArrayList<>());
        for (int i = 0; i < childNodeList.size(); i++) {
            int childNode = childNodeList.get(i);
            if (!visited[childNode]) {
                if (detectCycleInUndirectedGraph(childNode, node, visited)) {
                    return true;
                }
            } 
            else if (childNode != parent) {
                return true;
            }
        }
        return false;
    }

    public void bfs(int root, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[root] = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            System.out.println(parent);
            List<Integer> childNodeList = graph.getOrDefault(parent, new ArrayList<>());
            for (int i = 0; i < childNodeList.size(); i++) {
                if (!visited[childNodeList.get(i)]) {
                    queue.add(childNodeList.get(i));
                    visited[childNodeList.get(i)] = true;
                }
            }
        }
    }

    public boolean detectCycleInDirectedGraph(int root,boolean[] visited,boolean[] pathvisited) {
        
        visited[root]=true;
        pathvisited[root]=true;

        List<Integer> childNodeList=graph.getOrDefault(root, new ArrayList<>());
        for (int i=0;i<childNodeList.size();i++) {
            int childNode=childNodeList.get(i);
            if (!visited[childNode]) {
                if (detectCycleInDirectedGraph(childNode, visited, pathvisited)) {
                    return true;
                }
            }
            else if (pathvisited[childNode]) {
                return true;
            }
        }
        
        pathvisited[root]=false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("<======= GRAPH WORLD ========>");
        int V = 4;

        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 }
        };

        boolean[] visited = new boolean[V];

        Solution1 solution1 = new Solution1();

        solution1.buildUndirectedGraph(V, edges);
        solution1.printGraph();

        System.out.println("DFS => ");
        Arrays.fill(visited, false);
        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                solution1.dfs(0, visited);
            }
        }
        System.out.println("BFS => ");
        Arrays.fill(visited, false);
        solution1.bfs(0, visited);

        System.out.println("Detect Cycle In Undirected Graph => ");
        Arrays.fill(visited, false);
        boolean ans = solution1.detectCycleInUndirectedGraph(0, -1, visited);
        if (ans) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("Cycle Not Detected");
        }
    }
}
