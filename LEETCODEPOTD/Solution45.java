package LEETCODEPOTD;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution45 {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        boolean ans = false;
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] distance = new int[n][m];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = grid.get(0).get(0);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[2], b[2]);
        });
        pq.add(new Integer[] { 0, 0, grid.get(0).get(0) });
        while (!pq.isEmpty()) {
            Integer[] node = pq.poll();
            int x = node[0];
            int y = node[1];
            int d = node[2];
            if (d != distance[x][y]) {
                continue;
            }
            if ((x - 1) >= 0 && (distance[x][y] + grid.get(x - 1).get(y)) < distance[x - 1][y]) {
                distance[x - 1][y] = distance[x][y] + grid.get(x - 1).get(y);
                pq.add(new Integer[] { x - 1, y, distance[x - 1][y] });
            }
            if ((y - 1) >= 0 && (distance[x][y] + grid.get(x).get(y - 1)) < distance[x][y - 1]) {
                distance[x][y - 1] = distance[x][y] + grid.get(x).get(y - 1);
                pq.add(new Integer[] { x, y - 1, distance[x][y - 1] });
            }
            if ((x + 1) < n && (distance[x][y] + grid.get(x + 1).get(y)) < distance[x + 1][y]) {
                distance[x + 1][y] = distance[x][y] + grid.get(x + 1).get(y);
                pq.add(new Integer[] { x + 1, y, distance[x + 1][y] });
            }
            if ((y + 1) < m && (distance[x][y] + grid.get(x).get(y + 1)) < distance[x][y + 1]) {
                distance[x][y + 1] = distance[x][y] + grid.get(x).get(y + 1);
                pq.add(new Integer[] { x, y + 1, distance[x][y + 1] });
            }
        }
        if (distance[n - 1][m - 1] < health) {
            ans = true;
        } else {
            ans = false;
        }
        return ans;
    }
}
