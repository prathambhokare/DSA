import java.util.*;

public class 2DPrefixSum {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        this.matrix=matrix;
        for (int i=1;i<m;i++) {
            matrix[0][i]=matrix[0][i-1]+matrix[0][i];
        }
        for (int i=1;i<n;i++) {
            matrix[i][0]=matrix[i-1][0]+matrix[i][0];
        }
        for (int i=1;i<n;i++) {
            for (int j=1;j<m;j++) {
                matrix[i][j]=matrix[i][j]+matrix[i-1][j]+matrix[i][j-1]-matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top=(row1-1)<0 ? 0 : matrix[row1-1][col2];
        int left=(col1-1)<0 ? 0 : matrix[row2][col1-1];
        int topLeft=(row1-1<0 || col1-1<0) ? 0 : matrix[row1-1][col1-1];
        return matrix[row2][col2]-top-left+topLeft;
    }
}
