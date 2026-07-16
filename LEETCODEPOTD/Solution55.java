package LEETCODEPOTD;

import java.util.Arrays;

public class Solution55 {
    public int gcd(int a,int b) {
        if (b==0) {
            return Math.abs(a);
        }
        return gcd(b,a%b);
    }
    public long gcdSum(int[] nums) {
        long sum=0;
        int[] prefixGcd=new int[nums.length];
        int max=0;
        for (int i=0;i<nums.length;i++) {
            max=Math.max(max,nums[i]);
            prefixGcd[i]=gcd(nums[i],max);
        }
        Arrays.sort(prefixGcd);
        int i=0;
        int j=prefixGcd.length-1;
        while (i<j) {
            sum=sum+gcd(prefixGcd[i],prefixGcd[j]);
            i=i+1;
            j=j-1;
        }
        return sum;
    }
}
