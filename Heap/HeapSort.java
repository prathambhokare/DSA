package Heap;

import java.util.*;

public class HeapSort {

    public static void maxHeapify(int root,int len,int[] arr) {
        int max=root;
        int left=2*root+1;
        int right=2*root+2;
        if (left<len && arr[left]>arr[max]) {
            max=left;
        }
        if (right<len && arr[right]>arr[max]) {
            max=right;
        }
        if (max!=root) {
            swap(root,max,arr);
            maxHeapify(max,len,arr);
        }
    }

    public static void minHeapify(int root,int len,int[] arr) {
        int min=root;
        int left=2*root+1;
        int right=2*root+2;
        if (left<len && arr[min]>arr[left]) {
            min=left;
        }
        if (right<len && arr[min]>arr[right]) {
            min=right;
        }
        if (min!=root) {
            swap(root,min,arr);
            minHeapify(min,len,arr);
        }
    }

    public static void swap(int i,int j,int[] arr) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void heapSort(int[] arr) {
        for (int i=arr.length/2-1;i>=0;i--) {
            maxHeapify(i, arr.length, arr);   
        }
        for (int i=arr.length-1;i>=0;i--) {
            swap(0,i,arr);
            maxHeapify(0, i, arr);
        }
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        heapSort(new int[]{5,3,4,1,2});
    }
}
