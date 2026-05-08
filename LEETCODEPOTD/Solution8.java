import java.util.*;

public class Solution8 {

        public List<Boolean> isPrime=new ArrayList<>();
    public void buildSieve(int maxElement) {
        for (int i=0;i<=maxElement;i++) {
            if (i==0 || i==1) {
                isPrime.add(false);
            }
            else {
                isPrime.add(true);
            }
        }
        for (int num=2;num*num<=maxElement;num=num+1) {
            if (isPrime.get(num)) {
                for (int mul=num*num;mul<=maxElement;mul=mul+num) {
                    isPrime.set(mul,false);
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        int n=nums.length;
        int ans=0;
        int maxEl=0;
        //__Stores Elements And It's Index
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            List<Integer> ansval=mp.getOrDefault(nums[i],new ArrayList<>());
            ansval.add(i);
            mp.put(nums[i],ansval);
            maxEl=Math.max(maxEl,nums[i]);
        }
        //__Precompute all prime numbers till max element
        buildSieve(maxEl);
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[nums.length];
        Arrays.fill(visited,false);
        queue.add(0);
        visited[0]=true;
        Set<Integer> primeSeenBefore=new HashSet<>();
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i=0;i<size;i++) {
                int idx=queue.poll();
                if (idx==n-1) {
                    return ans;
                }
                if ((idx-1)>=0 && !visited[idx-1]) {
                    queue.add(idx-1);
                    visited[idx-1]=true;
                }
                if ((idx+1)<n && !visited[idx+1]) {
                    queue.add(idx+1);
                    visited[idx+1]=true;
                }
                if (!isPrime.get(nums[idx]) || primeSeenBefore.contains(nums[idx])) {
                    continue;
                }
                for (int mul=nums[idx];mul<=maxEl;mul=mul+nums[idx]) {
                    if (!mp.containsKey(mul)) {
                        continue;
                    }
                    for (Integer key : mp.get(mul)) {
                        queue.add(key);
                        visited[key]=true;
                    }
                }
                primeSeenBefore.add(nums[idx]);
            }
            ans=ans+1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}