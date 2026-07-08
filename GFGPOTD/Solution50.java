import java.util.HashMap;
import java.util.Map;

public class Solution50 {
    public int countKdivPairs(int[] arr, int k) {
        // code here
        int ans=0;
        // Arrays.sort(arr);
        Map<Integer,Integer> mp=new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            int ansval=(k-arr[i]%k)%k;
            // System.out.println(ansval);
            if (mp.containsKey(ansval)) {
                ans=ans+mp.get(ansval);
            }
            mp.put(arr[i]%k,mp.getOrDefault(arr[i]%k,0)+1);
        }
        return ans;
    }
}
