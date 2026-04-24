package LCHardProblem;

public class FirstMissingPositive {
        public int missingNumber(int[] arr) {
        // code here
        // Set<Integer> set=new HashSet<>();
        // for (int i=0;i<arr.length;i++) {
        //     set.add(arr[i]);
        // }
        // for (int i=1;i<=arr.length;i++) {
        //     if (!set.contains(i)) {
        //         return i;
        //     }
        // }
        // return arr.length+1;
        //Optimal Approach
        //1.clean the array
        for (int i=0;i<arr.length;i++) {
            if (arr[i]<=0 || arr[i]>arr.length) {
                arr[i]=arr.length+1;
            }
        }
        //2.mark the presence
        for (int i=0;i<arr.length;i++) {
            int val=Math.abs(arr[i]);
            if (val>arr.length) {
                continue;
            }
            if (arr[val-1]>0) {
                arr[val-1]=-arr[val-1];
            }
        }
        //3.find the first missing positive
        for (int i=0;i<arr.length;i++) {
            if (arr[i]>0) {
                return i+1;
            }
        }
        return arr.length+1;
    }
}
