package LCHardProblem;

public class MedianOfTwoSortedArray {
    public double findMedian(int[] nums1, int[] nums2) {
        double ans = 0.0;
        //Run Binary Search on Smaller Array
        int[] smaller=nums1.length>nums2.length ? nums2 : nums1;
        int[] larger=nums1.length>nums2.length ? nums1 : nums2;
        int totalLength=nums1.length+nums2.length;
        int low=0;
        int high=smaller.length;
        while (low<=high) {
            int partX=(low+high)/2;
            int partY=(totalLength+1)/2-partX;

            int l1=partX==0 ? Integer.MIN_VALUE : smaller[partX-1];
            int r1=partX==smaller.length ? Integer.MAX_VALUE : smaller[partX];

            int l2=partY==0 ? Integer.MIN_VALUE : larger[partY-1];
            int r2=partY==0 ? Integer.MAX_VALUE : larger[partY];

            if (l1<=r2 && l2<=r1) {
                if (totalLength%2==0) {
                    ans = (Math.max(l1, l2)+Math.min(r1,r2))/2;
                }
                else {
                    ans = (Math.max(l1, l2));
                }
                System.out.println("True Here " + ans);
                break;
            }
            if (l1>r2) {
                high=partX-1;
            }
            else {
                low=partX+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1=new int[]{1,12,15,26,38};
        int[] nums2=new int[]{1,13,17,30,45,60};
        MedianOfTwoSortedArray medianOfTwoSortedArray=new MedianOfTwoSortedArray();
        double result=medianOfTwoSortedArray.findMedian(nums1, nums2);
        System.out.println("The value of result is " + result);
    }
}
