package TwoPointer;

public class Solution1 {

    public static int countSubarrayWithSumLessThanK(int[] arr,int k) {
        int ans=0;
        int i=0;
        int j=0;
        int sum=0;
        while (j<arr.length) {

            sum=sum+arr[j];
            while (sum>k) {
                sum=sum-arr[i];
                i=i+1;
            }
            ans=ans+(j-i+1);
            j=j+1;
        }

        return ans;
    }

    public static int countSubarrayWithSumLessThanKPractice(int[] arr,int k) {
        int ans=0;
        int i=0;
        int j=0;
        int sum=0;
        while (j<arr.length) {
            sum=sum+arr[j];
            while (sum>k) {
                sum=sum-arr[i];
                i=i+1;
            }
            ans=ans+(j-i+1);
            j=j+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=countSubarrayWithSumLessThanK(new int[]{2,1,1,5,8}, 4);
        System.out.println(ans);
    }
}