import java.util.*;

public class Solution23 {
    
    public static boolean isSumOfConsecutive(int n) {
        // code here
        // int ansVal = (int) Math.ceil(n / 2.0);
        // Set<Long> set=new HashSet<>();
        // set.add((long)0);
        // set.add((long)1);
        // for (int i=2;i<=ansVal;i++) {
        //     Long sum = ((long) i * (i + 1)) / 2;
        //     // System.out.println(sum + " " + (sum-(long)n));
        //     set.add(sum);
        //     if (set.contains((sum-(long)n))) {
        //         return true;
        //     }
        // }
        // return false;
        return (n & (n - 1)) != 0;
    }

    public static void main(String[] args) {
        boolean ans=isSumOfConsecutive(10);
        System.out.println(ans);
    }
}
