public class Solution18 {

    public static int minToggle(int[] arr) {
        // code here
        int ans=Integer.MAX_VALUE;
        int[][] cnt=new int[arr.length][2];
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==1) {
                if ((i-1)>=0) {
                    cnt[i][0]=cnt[i][0]+1+cnt[i-1][0];
                }
                else {
                    cnt[i][0]=1;
                }
            }
            else {
                if ((i-1)>=0) {
                 cnt[i][0]=cnt[i][0]+cnt[i-1][0];
                }
            }
            if (arr[arr.length-i-1]==0) {
                if ((arr.length-i)<arr.length) {
                    cnt[arr.length-i-1][1]=cnt[arr.length-i-1][1]+1+cnt[arr.length-i][1];
                }
                else {
                    cnt[arr.length-i-1][1]=1;
                }
            }
            else {
                if ((arr.length-i)<arr.length) {
                    cnt[arr.length-i-1][1]=cnt[arr.length-i-1][1]+cnt[arr.length-i][1];
                }
            }
        }
        for (int i=0;i<cnt.length;i++) {
            // System.out.println(cnt[i][0] + " " + cnt[i][1]);
            int rightCost= (i + 1 < arr.length)
                ? cnt[i + 1][1]
                : 0;
            ans=Math.min(ans,cnt[i][0]+rightCost);
        }
        ans = Math.min(ans, cnt[0][1]);
        ans = Math.min(ans, cnt[arr.length - 1][0]);
        return ans;
    }

    public static void main(String[] args) {
        int ans=minToggle(new int[]{1,0,1,1,0});
        System.out.println(ans);
    }
}
