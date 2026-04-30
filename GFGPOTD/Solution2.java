import java.util.*;

public class Solution2 {
    public static int minSwaps(int[] arr) {
        // code here
        int ans=Integer.MAX_VALUE;
        //count number of one in arr
        int countOne=0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==1) {
                countOne=countOne+1;
            }
        }
        int currZeroCount=0;
        int i=0;
        int j=0;
        System.out.println("count one" + countOne);
        while (i<=(arr.length-countOne)) {
            if ((i-j+1)<countOne) {
                if (arr[i]==0) {
                    currZeroCount++;
                }
                // continue;
            }
            else {
                System.out.println(currZeroCount);
                if (arr[j]==0) {
                    currZeroCount--;
                }
                if (arr[i]==0) {
                    currZeroCount++;
                }
                j=j+1;
            }
            System.out.println("Window Length " + (i-j+1));
            if ((i-j+1)==countOne) {
                ans=Math.min(ans,currZeroCount);
            }
            i=i+1;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static void main(String[] args) {
        int[] input={1,0,1,0,1,1,1,1,1,0,1,0};
        int ans = minSwaps(input);
        System.out.println(ans);
    }
}
