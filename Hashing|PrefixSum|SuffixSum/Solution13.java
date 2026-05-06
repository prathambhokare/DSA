import java.util.*;

public class Solution13 {

    public static int subarrayMexes(int[] arr,int k) {
        int ans=0;
        //__Stores Occurences Of Each Item from 1....arr.length and it's index
        Map<Integer,Integer> mp=new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            mp.put(arr[i], i);
        }
        int[] mexs=new int[arr.length];
        Arrays.fill(mexs, 0);
        int left=-1;
        int right=-1;
        for (int i=1;i<=arr.length;i++) {
            if (mp.containsKey(i)) {
                int idx=mp.get(i);
                if (left==-1 && right==-1) {
                    left=idx;
                    right=idx;
                }
                else if (left<=idx && idx<=right) {
                    //do nothing
                }
                else if (idx>right) {
                    right=idx;
                }
                else if (idx<left) {
                    left=idx;
                }
                mexs[idx]=(left+1)*(arr.length-right);
            }
        }
        int sum=0;
        for (int i=0;i<mexs.length;i++) {
            sum=sum+mexs[i];
            if (sum>=k) {
                ans=i+1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = subarrayMexes(new int[]{3,2,1,4}, 5);
        System.out.println(ans);
    }
}
