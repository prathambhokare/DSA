import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution41 {
    // public int solve(int i,int j,int[] a,int[] b,int[][] dp) {
        
    //     if (i==a.length) {
    //         return b.length-j;
    //     }
        
    //     if (j==b.length) {
    //         return a.length-i;
    //     }
        
    //     if (dp[i][j]!=0) {
    //         return dp[i][j];
    //     }
        
    //     if (a[i]==b[j]) {
    //         return 0+solve(i+1,j+1,a,b,dp);
    //     }
    //     return dp[i][j]=Math.min(
    //         1+solve(i+1,j,a,b,dp),
    //         1+solve(i,j+1,a,b,dp)
    //         );
    // }
    // public int minInsAndDel(int[] a, int[] b) {
    //     // code here
    //     int[][] dp=new int[a.length+1][b.length+1];
    //     return solve(0,0,a,b,dp);
    // }
    
    public int minInsAndDel(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : a) {
            if (!map.containsKey(x))
                continue;
            int idx = map.get(x);
            int pos = Collections.binarySearch(list, idx);
            if (pos < 0)
                pos = -(pos + 1);
            if (pos == list.size()) {
                list.add(idx);
            } else {
                list.set(pos, idx);
            }
        }
        int lcs = list.size();
        return (a.length - lcs) + (b.length - lcs);
    }
}
