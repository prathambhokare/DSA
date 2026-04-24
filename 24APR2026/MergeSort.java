import java.util.*;

public class MergeSort {
    private void merge(int[] arr,int l,int m,int r) {
        
        int lS=m-l+1;
        int rS=r-m;
        int[] left=new int[lS];
        int[] right=new int[rS];
        for (int i=0;i<left.length;i++) {
            left[i]=arr[i+l];
        }
        for (int i=0;i<right.length;i++) {
            right[i]=arr[m+i+1];
        }
        int i=0;
        int j=0;
        int k=l;
        while (i<lS && j<rS) {
            if (left[i]>right[j]) {
                arr[k]=right[j];
                j=j+1;
            }
            else {
                arr[k]=left[i];
                i=i+1;
            }
            k=k+1;
        }
        while (i<lS) {
            arr[k]=left[i];
            i=i+1;
            k=k+1;
        }
        while (j<rS) {
            arr[k]=right[j];
            j=j+1;
            k=k+1;
        }
    }
    private void mergeSort(int arr[], int l, int r) {
        // code here
        if (l<r) {
            int m=l+(r-l)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    private void printArray(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr=new int[]{4, 1, 3, 9, 7};
        MergeSort mergeSort=new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length-1);
        mergeSort.printArray(arr);
    }
}
