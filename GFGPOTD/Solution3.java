package GFGPOTD;

import java.util.*;

public class Solution3 {
    
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->{
            return a-b;
        });
        //insert first 'k' elements into PQ
        for (int i=0;i<k;i++) {
            pq.add(arr[i]);
            if (i!=k-1) {
                ans.add(-1);
            }
            else {
                ans.add(pq.peek());
            }
        }
        int i=k;
        while (i<arr.length) {
            if (arr[i]>pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
            ans.add(pq.peek());
            i=i+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int k=4;
        List<Integer> ans=kthLargest(new int[]{1, 2, 3, 4, 5, 6}, k);
        for (int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
