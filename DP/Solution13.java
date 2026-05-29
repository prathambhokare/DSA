package DP;

import java.util.*;

public class Solution13 {
    
    public static int countingTiles(int n,int m) {
        
        if (n==0 && m==0) {
            return 0;
        }

        if (n<0 || m<0) {
            return Integer.MAX_VALUE;
        }

        int ans=0;
        int ansval=countingTiles(n-1, m-2);
        if (ansval!=Integer.MAX_VALUE) {
            ans=ans+ansval;
        }
        ansval=countingTiles(n-2, m-1);
        if (ansval!=Integer.MAX_VALUE) {
            ans=ans+ansval;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=countingTiles(4, 7);
        System.out.println(ans);
    }
}
