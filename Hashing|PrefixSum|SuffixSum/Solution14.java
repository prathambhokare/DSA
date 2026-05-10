import java.util.*;

public class Solution14 {

    public static void prefix2DSum(int[][] arr) {
        
        for (int i=1;i<arr.length;i++) {
            for (int j=1;j<arr[0].length;j++) {
                arr[i][j]=arr[i][j]+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }
    }

    public static int regionSum(int[][] arr,int topR,int topC,int bottomR,int bottomC) {
        int ans=0;
        ans=arr[bottomR][bottomC]-arr[bottomR][topC-1]-arr[topR-1][bottomC]+arr[topR-1][topC-1];
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr=new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        prefix2DSum(arr);
        int ans=regionSum(arr,1,1,2,2);
        System.out.println(ans);
    }
}
