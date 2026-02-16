class Solution {
    public List<int[]> twoSum(int[] ansval,int skipIdx,int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        List<int[]> ans=new ArrayList<>();
        for (int i=0;i<ansval.length;i++) {
            if (i==skipIdx) {
                continue;
            }
            if (mp.containsKey(target-ansval[i])) {
                ans.add(new int[]{ansval[i],target-ansval[i]});
            }
            mp.put(ansval[i],i);
        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            int target=-nums[i];
            int left=i+1;
            int right=nums.length-1;
            while (left<right) {
                int sum=nums[left]+nums[right];
                if (sum==target) {
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right && nums[left]==nums[left+1]) {
                        left=left+1;
                    }
                    while (left<right && nums[right]==nums[right-1]) {
                        right=right-1;
                    }
                    left=left+1;
                    right=right-1;
                }
                else if (sum<target) {
                    left=left+1;
                }
                else {
                    right=right-1;
                }
            }
        }
        return ans;
    }
}


// x+y+z=0;
// x+y=-z
