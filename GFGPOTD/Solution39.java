public class Solution39 {
    final int mod = 1000000007;
    public Integer[][][] dp;
    public int countstrings(int idx,int n,int k,int prev,int cnt) {
        
        if (cnt>k) {
            return 0;
        }
        
        if (idx==n) {
            if (cnt==k) {
                return 1;
            }
            return 0;
        }
       
        if (dp[idx][prev][cnt]!=null)
            return dp[idx][prev][cnt];
        
        int ans1=countstrings(idx+1,n,k,0,cnt);
        int newcount=cnt;
        if (prev==1) {
            newcount=newcount+1;
        }
        int ans2=countstrings(idx+1,n,k,1,newcount);
        return dp[idx][prev][cnt]=(ans1+ans2)%mod;
    }
    public int countStrings(int n, int k) {
        // code here
        dp=new Integer[n + 1][2][k + 1];
        int ans0=countstrings(1,n,k,0,0);
        int ans1=countstrings(1,n,k,1,0);
        return (ans0+ans1)%mod;
    }
}
