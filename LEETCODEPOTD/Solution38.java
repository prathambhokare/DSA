package LEETCODEPOTD;

public class Solution38 {
    public static int largestAltitude(int[] gain) {
        int ans=0;
        int curr=0;
        for (int i=0;i<gain.length;i++) {
            curr=curr+gain[i];
            ans=Math.max(ans,curr);
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=largestAltitude(new int[]{-5,1,5,0,-7});
        System.out.println(ans);
    }
}
