import java.util.*;

public class Solution35 {
    public boolean up(int i,int j,int[][] mat,int m,int n) {
        while (i>=0) {
            if (mat[i][j]==1) {
                return true;
            }
            i=i-1;
        }
        return false;
    }
    
    public boolean down(int i,int j,int[][] mat,int m,int n) {
        while (i<m) {
            if (mat[i][j]==1) {
                return true;
            }
            i=i+1;
        }
        return false; 
    }
    
    public boolean left(int i,int j,int[][] mat,int m,int n) {
        while (j>=0) {
            if (mat[i][j]==1) {
                return true;
            }
            j=j-1;
        }
        return false;
    }
    
    public boolean right(int i,int j,int[][] mat,int m,int n) {
        while (j<n) {
            if (mat[i][j]==1) {
                return true;
            }
            j=j+1;
        }
        return false;
    }
    
    public int findCoverage(int[][] mat) {
        // code here
        int ans=0;
        for (int i=0;i<mat.length;i++) {
            for (int j=0;j<mat[0].length;j++) {
                if (mat[i][j]==0) {
                    if (up(i,j,mat,mat.length,mat[0].length)) {
                        ans=ans+1;
                    }
                    if (down(i,j,mat,mat.length,mat[0].length)) {
                        ans=ans+1;
                    }   
                    if (left(i,j,mat,mat.length,mat[0].length)) {
                        ans=ans+1;
                    }
                    if (right(i,j,mat,mat.length,mat[0].length)) {
                        ans=ans+1;
                    }
                }
            }
        }
        return ans;
    }
}
