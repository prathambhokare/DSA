package LEETCODEPOTD;

import java.util.*;

public class Solution4 {

    public static void rotateItems(int i,int j,int[][] matrix) {
        int m=i;
        int n=j+1;
        int prevVal=matrix[i][j];
        int direction=0;
        while (true) {
            // System.out.println(m+ " " + n);
            int temp=matrix[m][n];
            matrix[m][n]=prevVal;
            prevVal=temp;
            if (direction==0) {
                if ((n+1)>matrix[0].length-1-i) {
                    direction=1;
                    m=m+1;
                }
                else {
                    n=n+1;
                }
            }
            else if (direction==1) {
                if ((m+1)>matrix.length-1-i) {
                    direction=2;
                    n=n-1;
                }
                else {
                    m=m+1;
                }
            }
            else if (direction==2) {
                if ((n-1)<i) {
                    direction=3;
                    m=m-1;
                }
                else {
                    n=n-1;
                }
            }
            else if (direction==3) {
                if ((m-1)<i) {
                    direction=0;
                    n=n+1;
                }
                else {
                    m=m-1;
                }
            }
            if (m==i && n==j) {
                break;
            }
        }
        matrix[i][j] = prevVal;
    }
    public static void rotate(int[][] matrix) {
        //__Direction of rotation is
        //__Right,Down,Left And Up
        //__Each Element Will Take This Direction
        //__0,0 -> 1,1 -> matrix.length/2 iteration required
        //__then for each element till matrix.length-1
        //__rotate cell element by 90 degree
        
        int n=matrix.length;
        for (int i=0;i<n/2;i++) {//__this many iteration required
            int tempValue=0;
            for (int j=0; j<n-1-2*i;j++) {
                rotateItems(i,i,matrix);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotate(matrix);
        //__print matrix
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
