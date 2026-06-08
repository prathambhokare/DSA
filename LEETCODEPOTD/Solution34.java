package LEETCODEPOTD;


class Solution34 {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans=new int[nums.length];
        // List<List<Integer>> list=new ArrayList<>();
        // for (int i=0;i<3;i++) {
        //     list.add(new ArrayList<>());
        // }
        // for (int i=0;i<nums.length;i++) {
        //     if (nums[i]<pivot) {
        //         list.get(0).add(nums[i]);
        //     }
        //     else if (nums[i]==pivot) {
        //         list.get(1).add(nums[i]);
        //     }
        //     else {
        //         list.get(2).add(nums[i]);
        //     }
        // }
        // int k=0;
        // for (int i=0;i<list.size();i++) {
        //     for (int j=0;j<list.get(i).size();j++) {
        //         ans[k]=list.get(i).get(j);
        //         k=k+1;
        //     }
        // }
        int i=0;
        int j=nums.length-1;
        int k=0;
        int l=nums.length-1;
        while (i<nums.length && j>=0) {
            if (nums[i]<pivot) {
                ans[k]=nums[i];
                k++;
            }
            if (nums[j]>pivot) {
                ans[l]=nums[j];
                l--;
                
            }
            i++;
            j--;
        }
        // System.out.println(l + " " + k);
        for (int m=k;m<=l;m++) {
            ans[m]=pivot;
        }
        return ans;
    }
}


class Solution {
    public int maxCoins(int[] nums) {
        int ans=0;
        int[] num=new int[nums.length+2];
        num[0]=1;
        for (int i=0;i<nums.length;i++) {
            num[i+1]=nums[i];
        }
        num[nums.length+1]=1;
        int[][] dp=new int[nums.length+2][nums.length+2];
        //__calculate for length==1
        // Range is from 1..1, 2..2, 3..3, 4..4, 5..5, 6..6, 7..7, 8..8, 9..9;
        int m=1;
        while (m<=nums.length) {
            dp[m][m]=num[m-1]*num[m]*num[m+1];
            m=m+1;
        }
        //__calculate for all length=2,3,4,5,6,7,8,9.......
        int len=2;
        for (len = 2; len <= nums.length; len++) {

            for (int i=1;i+len-1<=nums.length;i++) {
                int j=i+len-1;
                //[i.......j]
                //now fix every k which is to be destroyed at the last compute it's cost
                for (int k=i;k<=j;k++) {
                    dp[i][j]=Math.max(
                        dp[i][j], dp[i][k-1]+dp[k+1][j]
                                  + (num[i-1]*num[k]*num[j+1]));
                }
            }
        }
        return dp[1][nums.length];
    }
}
