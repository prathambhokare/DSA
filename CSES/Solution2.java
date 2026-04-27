import java.util.*;

public class Solution2 {
    public static long missingNumber(long n,long[] nums) {
        long sum=(n*(n+1)/2);
        long numSum=0;
        for (long num : nums) {
            numSum=numSum+num;
        }
        return sum-numSum;
        //Thanks Swami For Helping Me Out
    }
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        long[] nums=new long[n-1];
        for (int i=0;i<n-1;i++) {
            nums[i]=sc.nextLong();
        }
        long missingNumber=missingNumber((long)n,nums);
        System.out.println(missingNumber);
    }
}