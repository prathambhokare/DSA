import java.util.*;

class CheckIfValidTree {
    public Map<Integer,List<Integer>> buildGRAph(int n,int[][] edges) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for (int i=0;i<edges.length;i++) {
            int s=edges[i][0];
            int d=edges[i][1];
            List<Integer> edgesList=graph.getOrDefault(s,new ArrayList<>());
            List<Integer> edgesListRev=graph.getOrDefault(d,new ArrayList<>());
            edgesList.add(d);
            edgesListRev.add(s);
            graph.put(s,edgesList);
            graph.put(d,edgesListRev);
        }
        return graph;
    }
    public boolean checkIfCyclePresent(int child,int parent,Map<Integer,List<Integer>> graph,Set<Integer> visited) {

        if (visited.contains(child)) return true;
        List<Integer> childNodes=graph.getOrDefault(child,new ArrayList<>());
        boolean ans=false;
        visited.add(child);
        for (int i=0;i<childNodes.size();i++) {
            //NOT Allowed Node IF COMING FROM SAME Parent
            if (childNodes.get(i)!=parent) {
                ans=ans|checkIfCyclePresent(childNodes.get(i),child,graph,visited);
            }
        }
        return ans;
    }
    public boolean validTree(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph=buildGRAph(n,edges);
        Set<Integer> visited=new HashSet<>();
        if (!visited.contains(0) && checkIfCyclePresent(0,-1,graph,visited)) {
            return false;
        }
        return visited.size() == n;
    }
}
