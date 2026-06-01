import java.util.*;

public class Solution25 {

    public static int sumDiffPairs(int[] arr, int k) {
        // code here
        int ans=0;
        Arrays.sort(arr);
        if (arr.length==1) {
            return ans;
        }
        int j=arr.length-1;
        while (j>=0) {
            if (j!=0 && arr[j]-arr[j-1]<k) {
                ans=ans+arr[j]+arr[j-1];
                j=j-2;
            }
            else {
                j=j-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=sumDiffPairs(new int[]{3,5,10,15,17,12,9},4);
        System.out.println(ans);
    }
}
