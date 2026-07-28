import java.util.Arrays;

public class Solution54 {
    int minSubsets(int arr[]) {
        // code here
        int ans=1;
        Arrays.sort(arr);
        for (int i=0;i<arr.length-1;i++) {
            if (arr[i]+1==arr[i+1]) {
                continue;
            }
            else {
                ans=ans+1;
            }
        }
        return ans;
    }
}
