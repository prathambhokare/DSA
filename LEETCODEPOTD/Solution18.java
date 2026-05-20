package LEETCODEPOTD;

import java.util.HashSet;
import java.util.Set;

public class Solution18 {
    
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans=new int[A.length];
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<A.length;i++) {
            set.add(A[i]);
            int commonCount=0;
            for (int j=i;j>=0;j--) {
                if (set.contains(B[j])) {
                    commonCount=commonCount+1;
                }
            }
            ans[i]=commonCount;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans=findThePrefixCommonArray(new int[]{1,3,2,4}, new int[]{3,1,2,4});
        for (int i=0;i<ans.length;i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
