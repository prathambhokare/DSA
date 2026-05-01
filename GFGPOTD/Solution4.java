package GFGPOTD;

import java.util.*;

public class Solution4 {
    
    public static int findPosition(int n) {
        // code here
        int ans=0;
        int countSetBits=0;
        while (n!=0) {
            if (n%2==1) {
                countSetBits=countSetBits+1;
            }
            if (countSetBits>1) {
                ans=-1;
                return ans;
            }
            n=n/2;
            ans=ans+1;
        }
        if (countSetBits==0) {
            ans=-1;
            return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=findPosition(2);
        System.out.println(ans);
    }
}
