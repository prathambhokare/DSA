public class Solution42 {
    public int kadane(int[] arr, int skip){
        int cur = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(i==skip){
                continue;
            }
            if(cur==Integer.MIN_VALUE){
                cur=arr[i];
            }else{
                cur=Math.max(arr[i],cur+arr[i]);
            }
            ans=Math.max(ans,cur);
        }
        return ans;
    }
    public int maxSumSubarray(int[] arr) {
        // code here
        // int ans=Integer.MIN_VALUE;
        // if (arr.length==1) {
        //     return arr[0];
        // }
        // int sum=0;
        // int minval=Integer.MAX_VALUE;
        // int maxi=Integer.MIN_VALUE;
        // for (int i=0;i<arr.length;i++) {
        //     if (sum<0) {
        //         sum=arr[i];
        //         minval=arr[i];
        //     }
        //     else {
        //         sum=sum+arr[i];
        //         minval=Math.min(minval,arr[i]);
        //     }
        //     // System.out.println(sum + " -> " + minval);
        //     maxi=Math.max(maxi,sum);
        //     if (minval!=Integer.MIN_VALUE) {
        //         System.out.println(sum + " " + minval);
        //         ans=Math.max(ans,sum-minval);
        //     }
        // }
        // return ans;
        // int ans = kadane(arr,-1);
        // for(int i=0;i<arr.length;i++){
        //     ans=Math.max(ans,kadane(arr,i));
        // }
        // return ans;
        
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int[] keep = new int[n];
        int[] delete = new int[n];
        keep[0] = arr[0];
        delete[0] = Integer.MIN_VALUE;
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            keep[i] = Math.max(arr[i], keep[i - 1] + arr[i]);
            if (delete[i - 1] == Integer.MIN_VALUE) {
                delete[i] = keep[i - 1];
            } else {
                delete[i] = Math.max(delete[i - 1] + arr[i], keep[i - 1]);
            }
            ans = Math.max(ans, keep[i]);
            ans = Math.max(ans, delete[i]);
        }
        return ans;
    }
}
