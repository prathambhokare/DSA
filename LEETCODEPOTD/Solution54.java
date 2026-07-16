package LEETCODEPOTD;

public class Solution54 {
    public int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public int gcdOfOddEvenSums(int n) {
       int ans=0;
       int sumeven=0;
       int sumodd=0;
       for (int i=1;i<=2*n;i++) {
        if (i%2==0) {
            sumeven=sumeven+i;
        }
        else {
            sumodd=sumodd+i;
        }
       }
       ans=gcd(sumeven,sumodd);
       return ans;
    }
}
