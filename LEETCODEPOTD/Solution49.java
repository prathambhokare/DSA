package LEETCODEPOTD;

import java.util.Arrays;

public class Solution49 {
    public int removeCoveredIntervals(int[][] intervals) {
        int ans=0;
        Arrays.sort(intervals,(a,b)->{
            if (a[0]!=b[0]) {
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(b[1],a[1]);
        });
        int s=intervals[0][0];
        int e=intervals[0][1];
        int i=1;
        while (i<intervals.length) {
            if (intervals[i][0]>=s && intervals[i][1]<=e) {
                ans=ans+1;
            }
            else {
                s=intervals[i][0];
                e=intervals[i][1];
            }
            i=i+1;
        }
        ans=intervals.length-ans;
        return ans;
    }
}
