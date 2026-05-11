import java.util.*;

public class Solution1 {

    public static Map<Integer,List<Integer[]>> buildGraph(int[][] edges,int threshold) {

        Map<Integer,List<Integer[]>> graph=new HashMap<>();

        for (int i=0;i<edges.length;i++) {

            int s=edges[i][0];
            int d=edges[i][1];

            int w=edges[i][2]<=threshold?0:1;

            List<Integer[]> edgesList=
                    graph.getOrDefault(s,new ArrayList<>());

            edgesList.add(new Integer[]{d,w});

            graph.put(s,edgesList);

            List<Integer[]> edgesListRev=
                    graph.getOrDefault(d,new ArrayList<>());

            edgesListRev.add(new Integer[]{s,w});

            graph.put(d,edgesListRev);
        }

        return graph;
    }

    public static boolean checkIsPossible(
            int[][] edges,
            int threshold,
            int source,
            int target,
            int k,
            int n
    ) {

        Map<Integer,List<Integer[]>> graph=
                buildGraph(edges,threshold);

        int[] dist=new int[n];

        Arrays.fill(dist,Integer.MAX_VALUE);

        Deque<Integer> deque=new LinkedList<>();

        deque.addFirst(source);

        dist[source]=0;

        while (!deque.isEmpty()) {

            int parent=deque.pollFirst();

            List<Integer[]> childNodes=
                    graph.getOrDefault(parent,new ArrayList<>());

            for (Integer[] child : childNodes) {

                int childNode=child[0];

                int edgeWeight=child[1];

                int newWeight=dist[parent]+edgeWeight;

                if (newWeight<dist[childNode]) {

                    dist[childNode]=newWeight;

                    if (edgeWeight==0) {
                        deque.addFirst(childNode);
                    }
                    else {
                        deque.addLast(childNode);
                    }
                }
            }
        }

        return dist[target]<=k;
    }

    public static int minimumThreshold(
            int n,
            int[][] edges,
            int source,
            int target,
            int k
    ) {

        if (source==target) {
            return 0;
        }

        int ans=-1;

        int minWeight=Integer.MAX_VALUE;

        int maxWeight=Integer.MIN_VALUE;

        for (int i=0;i<edges.length;i++) {

            minWeight=Math.min(minWeight,edges[i][2]);

            maxWeight=Math.max(maxWeight,edges[i][2]);
        }

        int s=minWeight;

        int e=maxWeight;

        while (s<=e) {

            int threshold=s+(e-s)/2;

            if (checkIsPossible(
                    edges,
                    threshold,
                    source,
                    target,
                    k,
                    n
            )) {

                ans=threshold;

                e=threshold-1;
            }
            else {

                s=threshold+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int ans=minimumThreshold(
                6,
                new int[][]{
                        {0,1,5},
                        {1,2,3},
                        {3,4,4},
                        {4,5,1},
                        {1,4,2}
                },
                0,
                3,
                1
        );

        System.out.println(ans);
    }
}