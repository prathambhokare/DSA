import java.util.PriorityQueue;

public class Solution51 {
    public int mod=1000000007;
    public int maxAmount(int[] arr, int k) {
        // code here
        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(b,a);
        });
        for (int i=0;i<arr.length;i++) {
            pq.add(arr[i]);
        }
        while (!pq.isEmpty() && k>0) {
            int ansval=pq.poll();
            ans=(ans+ansval)%mod;
            if ((ansval-1)>0) {
                pq.add(ansval-1);
            }
            k=k-1;
        }
        return ans;
    }
}
