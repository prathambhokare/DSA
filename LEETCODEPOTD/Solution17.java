package LEETCODEPOTD;

public class Solution17 {
    
    public static int getCommon(int[] nums1, int[] nums2) {
        int ans=-1;
        int i=0;
        int j=0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i]>nums2[j]) {
                j=j+1;
            }
            else if (nums1[i]<nums2[j]) {
                i=i+1;
            }
            else {
                ans=nums1[i];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=getCommon(new int[]{1,2,3}, new int[]{2,4});
        System.out.println(ans);
    }
}
