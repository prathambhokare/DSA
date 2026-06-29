package JulyPractice.BinarySearch;

public class BinarySearch {

    //July 1st Week Binary Search
    //July 2nd Week Monotonic Stack And Queue
    //July 3rd Week Sliding Window and Two Pointers
    //July 4th Week PriorityQueue Questions

    //1. Search element in an array - Done
    //2. Find Upper and Lower bound of a given target element in an array - Done
    //3. Search in rotated sorted array I - Done
    //4. Search in rotated sorted array II - Done
    //5. Minimum in rotated sorted array - Done
    //6. How many times array is sorted - (Size - Min.Element Position In Array) - Done
    //7. Single element in an array - Done
    //8. Find peak element in an array - Done

    public int search(int[] arr,int target) {
        int low=0;
        int high=arr.length-1;
        while (low<=high) {
            int mid=(low+high)/2;
            if (arr[mid]==target) {
                return mid;
            }
            else if (arr[mid]<target) {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return -1;
    }

    public int lower_bound(int[] arr,int target) {
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while (low<=high) {
            int mid=(low+high)/2;
            if (arr[mid]>=target) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }

    public int searchInRotatedSortedArray(int[] nums,int target) {
        int low=0;
        int high=nums.length-1;
        while (low<=high) {
            int mid=(low+high)/2;

            //In rotated sorted array
            //There is always array element till mid
            //Or after mid are sorted
            //In somehow fashion
            
            if (nums[mid]==target) {
                return mid;
            }

            //__check if left is sorted or not
            if (nums[low]<=nums[mid]) {
                if (nums[low]<=target && target<=nums[mid]) {
                    high=mid-1;
                }
                else {
                    low=mid+1;
                }
            }
            else {//__check if right is sorted or not
                if (nums[high]>=target && target>=nums[mid]) {
                    low=mid+1;
                }
                else {
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public int searchInRotatedSortedArrayWithDuplicate(int[] nums,int target) {
        int low=0;
        int high=nums.length-1;
        while (low<=high) {
            int mid=(low+high)/2;

            //In rotated sorted array
            //There is always array element till mid
            //Or after mid are sorted
            //In somehow fashion

            //In this we got know where my element will lie
            //But with duplicate items it is impossible to make
            //Decision e.g. [3,1,2,3,2,1,3]
            //              low    mid   high
            //if we make choice go either left or right
            //then probably we will missed out target
            
            if (nums[mid]==target) {
                return mid;
            }

            if (nums[mid]==nums[low] && nums[mid]==nums[high]) {
                low=low+1;
                high=high-1;
                continue;
            }

            //__check if left is sorted or not
            if (nums[low]<=nums[mid]) {
                if (nums[low]<=target && target<=nums[mid]) {
                    high=mid-1;
                }
                else {
                    low=mid+1;
                }
            }
            else {//__check if right is sorted or not
                if (nums[high]>=target && target>=nums[mid]) {
                    low=mid+1;
                }
                else {
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public int minimumInRotatedSortedArray(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int low=0;
        int high=nums.length-1;
        while (low<=high) {
            int mid=(low+high)/2;
            if (nums[low]<=nums[high]) {
                ans=nums[low];
                break;
            }
            //__check if left is sorted or not
            if (nums[low]<=nums[mid]) {
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            else {//__check if right is sorted or not
                ans = Math.min(ans, nums[mid]);
                high=mid-1;
            }
        }
        return ans;
    }

    public int singleElement(int[] arr) {
        //check base cases
        if (arr[0]!=arr[1]) {
            return arr[0];
        }
        if (arr[arr.length-1]!=arr[arr.length-2]) {
            return arr[arr.length-1];
        }
        int low=1;
        int high=arr.length-2;
        while (low<=high) {
            int mid=(low+high)/2;
            if (arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) {
                return arr[mid];
            }
            if ((mid%2==0 && arr[mid]==arr[mid+1]) ||
                (mid%2==1 && arr[mid]==arr[mid-1])) {

                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return -1;
    }

    public int peakElement(int[] nums) {
        int ans=-1;
        if (nums.length==1) {
            return 0;
        }
        if (nums[0]>nums[1]) {
            return 0;
        }
        if (nums[nums.length-2]<nums[nums.length-1]) {
            return nums.length-1;
        }
        int low=1;
        int high=nums.length-2;
        while (low<=high) {
            int mid=(low+high)/2;
            if (nums[mid-1]<=nums[mid] && nums[mid]>=nums[mid+1]) {
                return mid;
            }
            if (nums[mid-1]<=nums[mid] && nums[mid]<=nums[mid+1]) {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return ans;
    }

    public int upper_bound(int[] arr,int target) {
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while (low<=high) {
            int mid=(low+high)/2;
            if (arr[mid]>target) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}
