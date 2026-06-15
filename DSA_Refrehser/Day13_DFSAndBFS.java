package DSA_Refrehser;

import java.util.*;

public class Day13_DFSAndBFS {

    // ================= FLOOD FILL =================

    public void floodfill(int[][] image, int sr, int sc,
                          int color, int oldcolor,
                          boolean[][] visited) {

        if (sr < 0 || sc < 0 ||
                sr >= image.length || sc >= image[0].length) {
            return;
        }

        if (visited[sr][sc]) {
            return;
        }

        if (image[sr][sc] != oldcolor) {
            return;
        }

        image[sr][sc] = color;
        visited[sr][sc] = true;

        floodfill(image, sr, sc + 1, color, oldcolor, visited);
        floodfill(image, sr + 1, sc, color, oldcolor, visited);
        floodfill(image, sr - 1, sc, color, oldcolor, visited);
        floodfill(image, sr, sc - 1, color, oldcolor, visited);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean[][] visited =
                new boolean[image.length][image[0].length];

        int oldcolor = image[sr][sc];

        floodfill(image, sr, sc, color, oldcolor, visited);

        return image;
    }

    // ================= ROTTING ORANGES =================

    public int orangesRotting(int[][] grid) {

        int ans = 0;

        Queue<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Integer[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean rottenFound = false;

            for (int i = 0; i < size; i++) {

                Integer[] rottanOrange = queue.poll();

                int j = rottanOrange[0];
                int k = rottanOrange[1];

                if ((j - 1) >= 0 && grid[j - 1][k] == 1) {
                    queue.add(new Integer[]{j - 1, k});
                    grid[j - 1][k] = 2;
                    rottenFound = true;
                }

                if ((k + 1) < grid[0].length && grid[j][k + 1] == 1) {
                    queue.add(new Integer[]{j, k + 1});
                    grid[j][k + 1] = 2;
                    rottenFound = true;
                }

                if ((j + 1) < grid.length && grid[j + 1][k] == 1) {
                    queue.add(new Integer[]{j + 1, k});
                    grid[j + 1][k] = 2;
                    rottenFound = true;
                }

                if ((k - 1) >= 0 && grid[j][k - 1] == 1) {
                    queue.add(new Integer[]{j, k - 1});
                    grid[j][k - 1] = 2;
                    rottenFound = true;
                }
            }

            if (rottenFound) {
                ans++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }

    // ================= NUMBER OF ISLANDS =================

    public void markConnectedNodesAsVisited(
            int i, int j, char[][] grid) {

        if (i < 0 || j < 0 ||
                i >= grid.length || j >= grid[0].length ||
                grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        markConnectedNodesAsVisited(i + 1, j, grid);
        markConnectedNodesAsVisited(i, j + 1, grid);
        markConnectedNodesAsVisited(i - 1, j, grid);
        markConnectedNodesAsVisited(i, j - 1, grid);
    }

    public int numIslands(char[][] grid) {

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    markConnectedNodesAsVisited(i, j, grid);
                    ans++;
                }
            }
        }

        return ans;
    }

    // ================= UTILITY =================

    public static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        Day13_DFSAndBFS obj = new Day13_DFSAndBFS();

        System.out.println("========== FLOOD FILL ==========");

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] floodResult =
                obj.floodFill(image, 1, 1, 2);

        printMatrix(floodResult);

        System.out.println("\n========== ROTTING ORANGES ==========");

        int[][] oranges = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int minutes =
                obj.orangesRotting(oranges);

        System.out.println("Minutes Required = " + minutes);

        System.out.println("\n========== NUMBER OF ISLANDS ==========");

        char[][] islands = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int count =
                obj.numIslands(islands);

        System.out.println("Number Of Islands = " + count);
    }
}