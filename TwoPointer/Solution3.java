package TwoPointer;

import java.util.*;

public class Solution3 {
    
    public static int longestSubarray(int[] nums,int limit) {
        int ans=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        int i=0;
        int j=0;
        while (j<nums.length) {
            minHeap.add(nums[j]);
            maxHeap.add(nums[j]);
            while (i<j && (maxHeap.peek()-minHeap.peek())>limit) {
                minHeap.remove(nums[i]);
                maxHeap.remove(nums[i]);
                i=i+1;
            }
            System.out.println(minHeap.peek() + " " + maxHeap.peek() + " " + (j-i+1));
            ans=Math.max(ans,(j-i+1));
            j=j+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=longestSubarray(new int[]{10,1,2,4,7,2}, 5);
        System.out.println(ans);
    }
}
