import java.util.Arrays;

public class Solution48 {
    public int largestArea(int n, int m, int[][] arr) {
        // code here
        int ans=0;
        int[] rows=new int[arr.length+2];
        int[] cols=new int[arr.length+2];
        rows[0]=0;
        cols[0]=0;
        rows[rows.length-1]=n+1;
        cols[cols.length-1]=m+1;
        for (int i=0;i<arr.length;i++) {
            rows[i]=arr[i][0];
            cols[i]=arr[i][1];
        }
        Arrays.sort(rows);
        Arrays.sort(cols);
        int maxrowdiff=0;
        int maxcoldiff=0;
        for (int i=1;i<rows.length;i++) {
            maxrowdiff=Math.max(maxrowdiff,rows[i]-rows[i-1]-1);
            maxcoldiff=Math.max(maxcoldiff,cols[i]-cols[i-1]-1);
        }
        ans=maxrowdiff*maxcoldiff;
        return ans;
    }
}

// 5-3=2 3-1=2

// 2 3
// 1 5

// [0, 2 , 5, 5+1] -> 3-1-1=1
// [0, 1 , 3, 5+1] -> 3-1-1=2

// 1  2  0

// 0  1  2
 

}
