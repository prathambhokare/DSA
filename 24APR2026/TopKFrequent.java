import java.util.*;

//Optimized approach using bucket sort
//time complexity  -> O(n)
//space complexity -> O(n)
public class TopKFrequent {
        public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        Map<Integer,Integer> mp=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int count=mp.getOrDefault(nums[i],0);
            mp.put(nums[i],count+1);
        }
        List<Integer>[] freq=new ArrayList[nums.length+1];
        for (int i=0;i<=nums.length;i++) {
            freq[i]=new ArrayList<>();
        }
        for (Integer key : mp.keySet()) {
            List<Integer> values=freq[mp.get(key)];
            values.add(key);
        }
        int j=0;
        for (int i=freq.length-1;i>=0;i--) {
            if (!freq[i].isEmpty()) {
                for (Integer val : freq[i]) {
                    if (k==0) break;
                    ans[j]=val;
                    j=j+1;
                    k=k-1;
                }
            }
        }
        return ans;
    }
}
