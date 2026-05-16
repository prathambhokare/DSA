import java.util.*;

public class Solution15 {
    
    public static int findSmallest(int[] arr) {
        // code here
        int ans=1;
        // 1 2 3 ->
        // total sum -> 6
        // 1 .... 6 or 7
        Arrays.sort(arr);
        for (int i=0;i<arr.length && arr[i]<=ans;i++) {
            ans=ans+arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=findSmallest(new int[]{3,1,2});
        System.out.println(ans);
    }
}
