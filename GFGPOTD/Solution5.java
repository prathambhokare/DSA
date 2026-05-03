import java.util.*;

public class Solution5 {
    
    public static ArrayList<Integer> sortBySetBitCount(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int[][] arrVal=new int[arr.length][2];
        for (int i=0;i<arr.length;i++) {
            arrVal[i][0]=arr[i];
            arrVal[i][1]=Integer.bitCount(arr[i]);
        }
        Arrays.sort(arrVal,(a,b)->{
            return b[1]-a[1];
        });
        for (int i=0;i<arr.length;i++) {
            // System.out.println(arrVal[i][0] + " " + arrVal[i][1]);
            ans.add(arrVal[i][0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result=sortBySetBitCount(new int[]{5,2,3,9,4,6,7,15,32});
        for (int i=0;i<result.size();i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }
}
