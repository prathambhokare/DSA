package LEETCODEPOTD;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] ansval=new int[grid.length*grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                int currpos=i*grid[0].length+j;
                ansval[(currpos+k)%ansval.length]=grid[i][j];
            }
        }
        // for (int i=0;i<ansval.length;i++) {
        //     System.out.print(ansval[i] + " ");
        // }
        System.out.println();
        for (int i=0;i<grid.length;i++) {
            List<Integer> ansvals=new ArrayList<>();
            for (int j=0;j<grid[0].length;j++) {
                ansvals.add(
                    ansval[i*grid[0].length+j]
                );
            }
            ans.add(
                ansvals
            );
        }
        return ans;
    }
}
