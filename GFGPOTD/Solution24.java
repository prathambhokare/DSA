import java.util.*;

public class Solution24 {

    public static int findMaxProduct(int[] arr) {
        // code here
        Arrays.sort(arr);
        int zeroCount=0;
        int negCount=0;
        int posCount=0;
        long prod=1;
        int firstNeg=1;
        if (arr.length==1) {
            return arr[0];
        }
        if (arr.length==2) {
            if ((arr[0]==0 || arr[1]==0) && (arr[0]==-1 || arr[1]==-1)) {
                return Math.max(arr[0],arr[1]);
            }
        }
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==0) {
                zeroCount=zeroCount+1;
            }
            else if (arr[i]<0) {
                // System.out.println(firstNeg);
                negCount=negCount+1;
                // if (firstNeg==1) {
                    firstNeg=arr[i];
                // }
            }
            else {
                posCount=posCount+1;
            }
            if (arr[i]!=0) {
                long MOD = 1000000007L;
                prod = (prod * arr[i]) % MOD;
            }
        }
        // System.out.println(prod + " " + firstNeg);
        if (zeroCount==arr.length) {
            prod=0;
            return (int)prod;
        }
        if (negCount%2==0) {
            return (int)prod;
        }
        else if (negCount%2!=0) {
            return (int)prod/firstNeg;
        }
        return 0;
    }

    public static void main(String[] args) {
        int ans=findMaxProduct(new int[]{-1,0,-2,4,3});
        System.out.println(ans);
    }
}
