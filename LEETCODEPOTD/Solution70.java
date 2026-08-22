package LEETCODEPOTD;

public class Solution70 {
    public boolean checkDivisibility(int n) {
        boolean ans=false;
        int ansval=0;
        int product=1;
        int value=n;
        while (n!=0) {
            ansval=ansval+n%10;
            product=product*(n%10);
            n=n/10;
        }
        System.out.println(ansval+product);
        if (value%(ansval+product)==0) {
            ans=true;
        }
        return ans;
    }
}
