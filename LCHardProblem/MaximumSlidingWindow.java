package LCHardProblem;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaximumSlidingWindow {
        public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer[]> pq=new PriorityQueue<>((a,b)->{
            if (a[0]==b[0]) {
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        for (int i=0;i<k;i++) {
            pq.add(new Integer[]{arr[i],i});
        }
        ans.add(pq.peek()[0]);
        for (int i=k;i<arr.length;i++) {
            pq.add(new Integer[]{arr[i], i});
            while (pq.peek()[1] <= i-k) {
                pq.poll();
            }
            ans.add(pq.peek()[0]);
        }
        // int i=-1;
        // int j=k;
        // while (j<arr.length) {
        //     List<Integer[]> valueList=new ArrayList<>();
        //     while (!pq.isEmpty()) {
        //         if (pq.peek()[1]>i) {
        //             valueList.add(new Integer[]{pq.peek()[0],pq.peek()[1]});
        //         }
        //         pq.poll();
        //     }
        //     for (Integer[] val: valueList) {
        //         pq.add(val);
        //     }
        //     ans.add(pq.peek()[0]);
        //     pq.add(new Integer[]{arr[j],j});
        //     i=i+1;
        //     j=j+1;
        // }
        //     List<Integer[]> valueList=new ArrayList<>();
        //     while (!pq.isEmpty()) {
        //         if (pq.peek()[1]>i) {
        //             valueList.add(new Integer[]{pq.peek()[0],pq.peek()[1]});
        //         }
        //         pq.poll();
        //     }
        //     for (Integer[] val: valueList) {
        //         pq.add(val);
        //     }
        //     ans.add(pq.peek()[0]);
        return ans;
    }
}
