package LEETCODEPOTD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution51 {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans=new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            ans[i]=arr[i];
        }
        Arrays.sort(arr);
        Map<Integer,Integer> mp=new HashMap<>();
        int ansval=1;
        for (int i=0;i<arr.length;i++) {
            if (!mp.containsKey(arr[i])) {
                mp.put(arr[i],ansval);
                ansval=ansval+1;
            }
        }
        for (int i=0;i<ans.length;i++) {
            ans[i]=mp.get(ans[i]);
        }
        return ans;
    }
}
