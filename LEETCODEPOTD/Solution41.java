package LEETCODEPOTD;

import java.util.Arrays;

public class Solution41 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int ans=1;
        Arrays.sort(arr);
        int start=1;
        for (int i=1;i<arr.length;i++) {
            if (Math.abs(arr[i]-start)<=1) {
                start=arr[i];
            }
            else {
                start=start+1;
            }
            ans=Math.max(ans,start);
        }
        return ans;
    }
}

// 1 100 10000
// 1 2 3


// 2 2 1 2 1
// 1 1 2 2 2

// sort them and then try
