package LEETCODEPOTD;

import java.util.PriorityQueue;

public class Solution35 {

    public static long maxTotalValue(int[] nums, int k) {
        long ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(b,a);
        });
        int max=nums[0];
        int min=nums[0];
        for (int i=0;i<nums.length;i++) {
            // int max=nums[i];
            // int min=nums[i];
            // for (int j=i+1;j<nums.length;j++) {
                max=Math.max(max,nums[i]);
                min=Math.min(min,nums[i]);
                pq.add(max-min);
            // }
        }
        while (k>0 && !pq.isEmpty()) {
            ans=ans+(long)pq.peek();
            k=k-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        long ans=maxTotalValue(new int[]{1,3,2}, 2);
        System.out.println(ans);
    }
}
