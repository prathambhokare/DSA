import java.util.*;

public class Solution10 {

    public static int maximumPointsCoveredByRectAngle(int[][] points,int x,int y) {
        int ans=0;
        //__initialize 2D matrix with points given
        int[][] prefixSum=new int[1000][1000];
        for (int i=0;i<points.length;i++) {
            prefixSum[points[i][0]][points[i][1]]++;
        }
        //__build 2D prefix array matrix
        for (int i=1;i<prefixSum.length;i++) {
            for (int j=1;j<prefixSum.length;j++) {
                prefixSum[i][j]=prefixSum[i][j]+prefixSum[i-1][j]+prefixSum[i][j-1]-prefixSum[i-1][j-1];
            }
        }
        //__count max points convered at each cell
        for (int i=x+1;i<prefixSum.length;i++) {
            for (int j=y+1;j<prefixSum.length;j++) {
                ans=Math.max(ans,prefixSum[i][j]-prefixSum[i-x-1][j]-prefixSum[i][j-y-1]+prefixSum[i-x-1][j-y-1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {
            {1, 1},
            {2, 3},
            {3, 4},
            {2, 4},
            {5, 5}
        };
        int x = 2, y = 2;

        int ans = maximumPointsCoveredByRectAngle(points,x,y);
        System.out.println(ans);
    }
}
