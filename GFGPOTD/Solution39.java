public class Solution39 {
    static final int mod = 1000000007;
    public static int countstrings(int idx,int n,int k,int prev,int cnt) {
        
        if (cnt>k) {
            return 0;
        }
        
        if (idx==n) {
            if (cnt==k) {
                return 1;
            }
            return 0;
        }
        
        int ans1=countstrings(idx+1,n,k,0,cnt);
        int newcount=cnt;
        if (prev==1) {
            newcount=newcount+1;
        }
        int ans2=countstrings(idx+1,n,k,1,newcount);
        return (ans1+ans2)%mod;
    }
    public static int countStrings(int n, int k) {
        // code here
        int ans0=countstrings(1,n,k,0,0);
        int ans1=countstrings(1,n,k,1,0);
        return (ans0+ans1)%mod;
    }

    public static void main(String[] args) {
        int ans=countStrings(3,2);
        System.out.println(ans);
    }
}
