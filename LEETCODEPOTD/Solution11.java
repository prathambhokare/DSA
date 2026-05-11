package LEETCODEPOTD;

import java.util.*;

public class Solution11 {

    public static List<Integer> splitNumber(int num) {
        List<Integer> ans=new ArrayList<>();
        while (num!=0) {
            ans.add(num%10);
            num=num/10;
        }
        return ans;
    }
    public static int[] separateDigits(int[] nums) {
        List<Integer> ansval=new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            List<Integer> digits=splitNumber(nums[i]);
            for (int j=digits.size()-1;j>=0;j--) {
                ansval.add(digits.get(j));
            }
        }
        int[] ans=new int[ansval.size()];
        for (int i=0;i<ans.length;i++) {
            ans[i]=ansval.get(i);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] ans=separateDigits(new int[]{13,25,83,77});
        for (int i=0;i<ans.length;i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
