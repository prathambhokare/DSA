package LEETCODEPOTD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution9 {
    
    public static int[][] rotateGrid(int[][] grid, int b) {
        int n=grid.length;
        int m=grid[0].length;
        int totalLayers=Math.min(m/2,n/2);
        for (int layer=0;layer<totalLayers;layer++) {
            List<Integer> layersItem=new ArrayList<>();
            //__initialize four pointers for each layer
            int top=layer;
            int right=m-layer-1;
            int bottom=n-layer-1;
            int left=layer;
            //__traverse top to right
            for (int i=left;i<=right;i++) {
                layersItem.add(grid[top][i]);
            }
            //__traverse right to bottom
            for (int i=top+1;i<=bottom-1;i++) {
                layersItem.add(grid[i][right]);
            }
            //__traverse right to left
            for (int i=right;i>=left;i--) {
                layersItem.add(grid[bottom][i]);
            }
            //__traverse left to top
            for (int i=bottom-1;i>=top+1;i--) {
                layersItem.add(grid[i][left]);
            }
            // for (int i=0;i<layersItem.size();i++) {
            //     System.out.print(layersItem.get(i) + " ");
            // }
            // System.out.println();
            //Rotate ArrayList Elements By 'K' Position
            Collections.rotate(layersItem,-(b%layersItem.size()));
            int k=0;
            //__traverse top to right
            for (int i=left;i<=right;i++) {
                grid[top][i]=layersItem.get(k);
                k=k+1;
            }
            //__traverse right to bottom
             for (int i=top+1;i<=bottom-1;i++) {
                grid[i][right]=layersItem.get(k);
                k=k+1;
            }
            //__traverse right to left
            for (int i=right;i>=left;i--) {
                grid[bottom][i]=layersItem.get(k);
                k=k+1;
            }
            //__traverse left to top
            for (int i=bottom-1;i>=top+1;i--) {
                grid[i][left]=layersItem.get(k);
                k=k+1;
            }
        }
        return grid;
    }

    public static void printGrid(int[][] grid) {
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] ans=rotateGrid(new int[][]{
            {1,2,3},
            {3,4,5},
            {6,7,8},
            {9,10,11}
        }, 3);
        printGrid(ans);
    }
}
