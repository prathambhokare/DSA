package LEETCODEPOTD;

import java.util.*;

public class Solution6 {

    public static char[][] rotateTheBox(char[][] box) {
        char[][] ans=new char[box[0].length][box.length];

        int n=box.length;
        int m=box[0].length;

        for (int i=0;i<n;i++) {
            int emptyCell=m-1;
            for (int j=m-1;j>=0;j--) {
                if (box[i][j]=='*') {
                    emptyCell=j-1;
                }
                else if (box[i][j]=='#') {
                    //__perform swap between stone and empty cells
                    char currVal=box[i][j];
                    box[i][j]='.';
                    box[i][emptyCell]=currVal;
                    emptyCell=emptyCell-1;
                }
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                ans[j][n-i-1]=box[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { '#', '.', '*', '.' },
                { '#', '#', '*', '.' }
        };

        char[][] ans = rotateTheBox(matrix);
        for (int i=0;i<ans.length;i++) {
            for (int j=0;j<ans[0].length;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
