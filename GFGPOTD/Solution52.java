public class Solution52 {
    public boolean isPossible(int[] arr, long mid) {
        for (int i = 0; i < arr.length; i++) {
            if (mid >= Long.MAX_VALUE / 2) {
                mid = Long.MAX_VALUE;
            } else {
                mid = 2 * mid - arr[i];
            }
            if (mid < 0) {
                return false;
            }
        }

        return true;
    }


    public int find(int[] arr) {
        long low = 1;
        long high = (long)1e9;
        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(arr, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)ans;
    }
}
