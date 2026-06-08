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
