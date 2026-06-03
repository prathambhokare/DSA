import java.util.*;

public class Solution27 {
    
    public static int maxSubstring(String s) {
        // code here
        int ans=0;
        int cntOne=0;
        int cntZero=0;
        int i=0;
        int j=0;
        while (j<s.length()) {
            if (s.charAt(j)=='0') {
                cntZero=cntZero+1;
            }
            else {
                cntOne=cntOne+1;
            }
            while (i<=j && cntOne>cntZero) {
                if (s.charAt(j)=='0') {
                    cntZero=cntZero-1;
                }
                else {
                    cntOne=cntOne-1;
                }
                i=i+1;
            }
            ans=Math.max(ans,cntZero-cntOne);
            j=j+1;
        }
        return ans==0?-1:ans;
    }

    public static void main(String[] args) {
        int ans=maxSubstring("11000010001");
        System.out.println(ans);
    }
}
