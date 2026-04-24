import java.util.*;


public class QuickSort {

    public void quickSort(int[] arr,int low,int high) {
        if (low<high) {
            int pivotIndex=partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot=arr[high];
        int s=low;
        int e=high-1;
        while (s<=e) {
            if (arr[s]>pivot) {
                swap(arr, s, e);
                e=e-1;
            }
            else {
                s=s+1;
            }
        }
        swap(arr, s, high);
        return s;
    }

    private void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private void printArray(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Hello World!!!!");
        int[] arr=new int[]{4, 1, 3, 9, 7};
        QuickSort sort=new QuickSort();
        sort.quickSort(arr,0,arr.length-1);
        sort.printArray(arr);
    }
}