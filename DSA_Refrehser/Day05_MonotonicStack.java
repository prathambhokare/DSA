package DSA_Refrehser;

import java.util.*;

public class Day05_MonotonicStack {

    public static int[] nextGreaterElement(int[] nums2) {
        int[] ans = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(nums2[i]);
        }
        return ans;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            mp.put(nums1[i], i);
        }
        int[] ans = nextGreaterElement(nums2);
        for (int i = 0; i < ans.length; i++) {
            // System.out.println(ans[i] + " ");
        }
        int j = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (mp.containsKey(nums2[i])) {
                nums1[mp.get(nums2[i])] = ans[i];
            }
        }
        return nums1;
    }

    public static int[] monotonic(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                while (!st.isEmpty() && st.peek() <= nums[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = st.peek();
                }
            }
            st.push(nums[i]);
        }
        return result;
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[nums.length + i] = nums[i];
        }
        int[] ans = monotonic(result);
        result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = ans[i];
        }
        return result;
    }

    public static int[] nextWarmerTempreture(int[] tempretures) {
        int[] ans = new int[tempretures.length];
        Stack<Integer[]> st = new Stack<>();
        for (int i = tempretures.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek()[0] <= tempretures[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = i;
            } else {
                ans[i] = st.peek()[1];
            }
            st.push(new Integer[] { tempretures[i], i });
        }
        return ans;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int[] ansval = nextWarmerTempreture(temperatures);
        for (int i = temperatures.length - 1; i >= 0; i--) {
            ans[i] = ansval[i] - i;
        }
        return ans;
    }

    public static int[] nextSmallerBarHeight(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer[]> st = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek()[0] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek()[1];
            }
            st.push(new Integer[] { heights[i], i });
        }
        return ans;
    }

    public static int[] prevSmallerBarHeight(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer[]> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && st.peek()[0] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek()[1];
            }
            st.push(new Integer[] { heights[i], i });
        }
        return ans;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int largestRectangleArea(int[] heights) {
        int ans = 0;
        int[] nextSmaller = nextSmallerBarHeight(heights);
        int[] prevSmaller = prevSmallerBarHeight(heights);
        // printArray(nextSmaller);
        // printArray(prevSmaller);
        for (int i = 0; i < heights.length; i++) {
            int width = 0;
            int height = heights[i];

            int prev = prevSmaller[i];
            int next = nextSmaller[i];

            int leftBoundary = prev;
            int rightBoundary = (next == -1) ? heights.length : next;

            width = rightBoundary - leftBoundary - 1;
            ans = Math.max(ans, width * height);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("===== Next Greater Element I =====");
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        // Expected: [-1, 3, -1]

        System.out.println();

        System.out.println("===== Next Greater Element II (Circular) =====");
        int[] circular = { 1, 2, 1 };
        System.out.println(Arrays.toString(nextGreaterElements(circular)));
        // Expected: [2, -1, 2]

        System.out.println();

        System.out.println("===== Daily Temperatures =====");
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        // Expected: [1,1,4,2,1,1,0,0]

        System.out.println();

        System.out.println("===== Next Smaller Bar Height =====");
        int[] histogram = { 2, 1, 5, 6, 2, 3 };
        System.out.println(Arrays.toString(nextSmallerBarHeight(histogram)));
        // Expected: [1,-1,4,4,-1,-1]

        System.out.println();

        System.out.println("===== Previous Smaller Bar Height =====");
        System.out.println(Arrays.toString(prevSmallerBarHeight(histogram)));
        // Expected: [-1,-1,1,2,1,4]

        System.out.println();

        System.out.println("===== Largest Rectangle In Histogram =====");
        System.out.println(largestRectangleArea(histogram));
        // Expected: 10

        System.out.println();

        System.out.println("===== More Histogram Tests =====");

        int[] test1 = { 2, 4 };
        System.out.println("Input : " + Arrays.toString(test1));
        System.out.println("Answer: " + largestRectangleArea(test1));
        // Expected: 4

        int[] test2 = { 2, 2, 2, 2 };
        System.out.println("Input : " + Arrays.toString(test2));
        System.out.println("Answer: " + largestRectangleArea(test2));
        // Expected: 8

        int[] test3 = { 6, 5, 4, 3, 2, 1 };
        System.out.println("Input : " + Arrays.toString(test3));
        System.out.println("Answer: " + largestRectangleArea(test3));
        // Expected: 12

        int[] test4 = { 1, 2, 3, 4, 5 };
        System.out.println("Input : " + Arrays.toString(test4));
        System.out.println("Answer: " + largestRectangleArea(test4));
        // Expected: 9

        System.out.println();

        System.out.println("===== Monotonic Stack Demo =====");
        int[] mono = { 2, 1, 2, 4, 3 };
        System.out.println(Arrays.toString(monotonic(mono)));
    }
}