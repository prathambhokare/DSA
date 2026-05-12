import java.util.*;

public class Solution8 {
    
    public static int bitStrings(int n) {
        double ans=0;
        int mod=1_000_000_000;
        ans=Math.pow((double)2,(double)n);
        return (int)(ans%mod);

    }

    public static int trailingZeros(int n) {
        int multipleOfFive=n/5;
        return multipleOfFive;
    }
    public static void main(String[] args) {
        int ans=bitStrings(10);
        System.out.println(ans);
        ans=trailingZeros(20);
        System.out.println(ans);
    }
}


// 20! 

// 20 * 16 ...... *15 * 

// 5!

// 5*4*3*2*1= 120
// 10!

// 10*9*8*7*6*5*4*3*2*1=720*7*6*5*4*3*2*1

// 20*15*10*5*2

// 20*10*10=2000*15=30000