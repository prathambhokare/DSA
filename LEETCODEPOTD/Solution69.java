package LEETCODEPOTD;

import java.util.ArrayList;
import java.util.List;

public class Solution69 {
    public int[] resultArray(int[] nums) {
        int[] ans=new int[nums.length];
        List<Integer> arr=new ArrayList<>();
        List<Integer> arr1=new ArrayList<>();
        arr.add(nums[0]);
        ans[0]=nums[0];
        int j=1;
        for (int i=1;i<nums.length;i++) {
            if (!arr1.isEmpty() && arr.get(arr.size()-1)>arr1.get(arr1.size()-1)) {
                arr.add(nums[i]);
                ans[j]=nums[i];
                j=j+1;
            }
            else {
                arr1.add(nums[i]);
            }
        }
        for (int i=0;i<arr1.size();i++) {
            ans[j]=arr1.get(i);
            j=j+1;
        }
        return ans;
    }
}
