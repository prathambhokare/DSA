package LEETCODEPOTD;

import java.util.*;

public class Solution6 {

    public static char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;

        for (int i = 0; i < n; i++) {
            int empty = m - 1; //__position to place '#'

            for (int j = m - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    empty = j - 1; //__reset after obstacle
                } else if (box[i][j] == '#') {
                    char temp = box[i][empty];
                    box[i][empty] = '#';
                    box[i][j] = temp;
                    empty--;
                }
            }
        }

        char[][] ans = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][n - 1 - i] = box[i][j];
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
