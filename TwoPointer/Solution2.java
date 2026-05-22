package TwoPointer;

public class Solution2 {

    public static int[] mergeTwoSortedArrays(int[] arr1,int[] arr2) {
        int[] ans=new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<arr1.length && j<arr2.length) {
            if (arr1[i]>=arr2[j]) {
                ans[k]=arr2[j];
                j=j+1;
            }
            else {
                ans[k]=arr1[i];
                i=i+1;
            }
            k=k+1;
        }
        while (i<arr1.length) {
            ans[k]=arr1[i];
            k=k+1;
            i=i+1;
        }
        while (j<arr2.length) {
            ans[k]=arr2[j];
            k=k+1;
            j=j+1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] ans=mergeTwoSortedArrays(new int[]{1,3,4,5}, new int[]{2,4,6,8});
        for (int i=0;i<ans.length;i++) {
            System.out.print(ans[i]+ " ");
        }
        System.out.println();
    }
}
