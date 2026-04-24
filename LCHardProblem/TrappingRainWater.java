import java.util.*;


// https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
public class TrappingRainWater {
    public int maxWater(int arr[]) {
        // code here
        int ans=0;
        int[] maxLeft=new int[arr.length];
        int[] maxRight=new int[arr.length];
        maxLeft[0]=arr[0];
        maxRight[arr.length-1]=arr[arr.length-1];
        for (int i=1;i<arr.length;i++) {
            maxLeft[i]=Math.max(maxLeft[i-1],arr[i]);
        }
        for (int i=arr.length-2;i>=0;i--) {
            maxRight[i]=Math.max(maxRight[i+1],arr[i]);
        }
        for (int i=0;i<arr.length;i++) {
            //water trapped at each block
            //waterTrap=min(maxLeft[i],maxRight[i])-height[i]
            int ansval=Math.min(maxLeft[i],maxRight[i])-arr[i];
            if (ansval>=0) {
                ans=ans+ansval;
            }
        }
        return ans;
    }
}