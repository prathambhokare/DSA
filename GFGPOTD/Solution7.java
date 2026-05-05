import java.util.*;

public class Solution7 {
    
    public static long sumXOR(int[] arr) {
        // code here
        long ans=0;
        for (int i=0;i<32;i++) {
            int zeroCount=0;
            int oneCount=0;
            for (int j=0;j<arr.length;j++) {
                if ((arr[j]>>i&1)==1) {
                    oneCount=oneCount+1;
                }
                else {
                    zeroCount=zeroCount+1;
                }
            }
            ans=ans+(long)oneCount*zeroCount*(1<<i);
        }
        return ans;
    }

    public static void main(String[] args) {
        long ans = sumXOR(new int[]{7,3,5});
        System.out.println(ans);
    }
}
