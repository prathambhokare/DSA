class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map<Integer,Integer> mp=new HashMap<>();
        // for (int i=0;i<nums.length;i++) {
        //     if (mp.containsKey(target-nums[i])) {
        //         return new int[]{mp.get(target-nums[i]),i};
        //     }
        //     mp.put(nums[i],i);
        // }
        int[] ans=new int[2];
        // for (int i=0;i<nums.length;i++) {
        //     if (mp.containsKey(target-nums[i])) {
        //         System.out.println(target-nums[i]);
        //         List<Integer> indexes=mp.get(target-nums[i]);
        //         ans[0]=i;
        //         for (int j=0;j<indexes.size();j++) {
        //             if (indexes.get(j)!=i) {
        //                 ans[1]=indexes.get(j);
        //                 return ans;
        //             }
        //         }
        //     }
        // }
        //two pointer
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while (i<j) {
            int sum=nums[i]+nums[j];
            if (sum<target) {
                i=i+1;
            }
            else if (sum==target) {
                return new int[]{i,j};
            }
            else {
                j=j-1;
            }
        }
        return ans;
    }
}