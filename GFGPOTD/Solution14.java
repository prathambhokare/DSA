import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution14 {
    
    public Map<Integer,List<Integer>> buildGraph(int[][] edges) {
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for (int i=0;i<edges.length;i++) {
            List<Integer> edgesList=mp.getOrDefault(edges[i][0],new ArrayList<>());
            edgesList.add(edges[i][1]);
            mp.put(edges[i][0],edgesList);
        }
        return mp;
    }
    public void runDfs(int parent,Map<Integer,List<Integer>> graph,Set<Integer> visited) {
        visited.add(parent);
        List<Integer> childNodes=graph.getOrDefault(parent,new ArrayList<>());
        for (int i=0;i<childNodes.size();i++) {
            if (!visited.contains(childNodes.get(i))) {
                runDfs(childNodes.get(i),graph,visited);
            }
        }
    }
    public int findMotherVertex(int V, int[][] edges) {
        // code here
        int ans=-1;
        Map<Integer,List<Integer>> graph=buildGraph(edges);
        Set<Integer> visited=new HashSet<>();
        for (int i=0;i<V;i++) {
            if (!visited.contains(i)) {
                runDfs(i,graph,visited);
                ans=i;
            }
        }
        visited.clear();
        runDfs(ans, graph, visited);
        if (visited.size()!=V) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}
