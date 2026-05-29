import java.util.*;

public class Solution22 {

    public static void replaceElements(int[] arr) {
        // code here
        int[] ansval=new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            ansval[i]=arr[i];
        }
        for (int i=0;i<arr.length;i++) {
            if (i==0) {
                arr[i]=ansval[i]^ansval[i+1];
            }
            else if (i!=arr.length-1) {
                arr[i]=ansval[i-1]^ansval[i+1];
            }
            else { 
                arr[i]=ansval[arr.length-1]^ansval[arr.length-2];
            }
        }
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        replaceElements(new int[]{2,1,4,7});
    }
}
