import java.util.*;

public class Solution16 {
    
    public static void runDfs(int i,int j,int[][] grid,boolean[][] visited) {
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 || visited[i][j]==true) {
            return;
        }
        grid[i][j]=0; 
        visited[i][j]=true;
        runDfs(i,j+1,grid,visited);
        runDfs(i+1,j,grid,visited);
        runDfs(i-1,j,grid,visited);
        runDfs(i,j-1,grid,visited);
    }
    public static int cntOnes(int[][] grid) {
        // code here
        int ans=0;
        boolean[][] visited=new boolean[grid.length+1][grid[0].length+1];
        for (int i=0;i<visited.length;i++) {
            Arrays.fill(visited[i],false);
        }
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j]==1 && (i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1)) {
                    // System.out.println("true here" + grid[i][j]);
                    runDfs(i,j,grid,visited);
                }
            }
        }
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                // System.out.print(grid[i][j] + " ");
                if (grid[i][j]==1) {
                    ans=ans+1;
                }
            }
            // System.out.println();
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=cntOnes(new int[][]{
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        });
        System.out.println(ans);
    }
}
