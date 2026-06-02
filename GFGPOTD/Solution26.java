import java.util.*;

public class Solution26 {

    public int lowerBound(List<Integer> list, int l) {
        int i = 0;
        int j = list.size() - 1;
        int ans = list.size();

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (list.get(mid) >= l) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

    public int upperBound(List<Integer> list, int r) {
        int i = 0;
        int j = list.size() - 1;
        int ans = list.size();

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (list.get(mid) > r) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> ansval = mp.getOrDefault(arr[i], new ArrayList<>());
            ansval.add(i);
            mp.put(arr[i], ansval);
        }

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];
            int ansval = queries[i][2];

            List<Integer> list = mp.getOrDefault(ansval, new ArrayList<>());

            if (list.size() == 0) {
                ans.add(0);
            } else {
                int lowerBound = lowerBound(list, l);
                int upperBound = upperBound(list, r);

                ans.add(upperBound - lowerBound);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Solution26 obj = new Solution26();

        // Example 1
        int[] arr1 = {1, 2, 1, 3, 1, 2, 3};

        int[][] queries1 = {
                {0, 4, 1},
                {2, 5, 2},
                {1, 6, 3},
                {0, 6, 5}
        };

        System.out.println(obj.freqInRange(arr1, queries1));
        // Expected: [3, 1, 2, 0]

        // Example 2
        int[] arr2 = {11, 21, 51, 101, 11, 51};

        int[][] queries2 = {
                {0, 4, 11},
                {2, 5, 51}
        };

        System.out.println(obj.freqInRange(arr2, queries2));
        // Expected: [2, 2]

        // Additional Test Case
        int[] arr3 = {5, 5, 5, 5, 5};

        int[][] queries3 = {
                {0, 4, 5},
                {1, 3, 5},
                {2, 2, 5},
                {0, 4, 10}
        };

        System.out.println(obj.freqInRange(arr3, queries3));
        // Expected: [5, 3, 1, 0]
    }
}