public class Solution32 {
    
    public static boolean binarySearch(int i,int j,int target,int[] arr) {
        
        while (i<=j) {
            int mid=(j+i)/2;
            if (arr[mid]<target) {
                i=mid+1;
            }
            else if (arr[mid]==target) {
                return true;
            }
            else {
                j=mid-1;
            }
        }
        return false;
    }

    public static int binarySearchable(int[] arr) {
        // code here
        int ans=0;
        for (int i=0;i<arr.length;i++) {
            if (binarySearch(0,arr.length-1,arr[i],arr)) {
                ans=ans+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=binarySearchable(new int[]{1,3,2});
        System.out.println(ans);
    }
}
