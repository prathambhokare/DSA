import java.util.*;

public class Solution4 {

    //__Find Out Maxiumum Subarray Sum
    //___When First And Last Index Of An Array Is Same
    public static int maxisumSubarraySum(int[] nums) {
        int ans=Integer.MIN_VALUE;
        //_Approach
        //__Maintains HashMap Which Stores Minium Sum Value Ending At Element Value I
        //___Then For Any Element J where J==I In Array Maximum Subarray Would Be P[J]-P[I-1]
        Map<Integer,Integer> mp=new HashMap<>();
        int prefixsum=0;
        for (int i=0;i<nums.length;i++) {
            //__Check If Value Is Already Present Or Not If Yes Then Calculate Answer
            if (mp.containsKey(nums[i])) {
                ans=Math.max(ans,(prefixsum+nums[i]-mp.get(nums[i])));
                if (mp.get(nums[i])>prefixsum) {
                    mp.put(nums[i],prefixsum);
                }
            }
            else {
                mp.put(nums[i], prefixsum);//__Else Update HashMap
            }
            prefixsum=prefixsum+nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=maxisumSubarraySum(new int[]{1,8,10,8,-5,8});
        System.out.println(ans);
    }
}
