package DSA_Refrehser;

import java.util.*;

public class Day06_PriorityQueue {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // -------------------------------
    // Kth Largest using Heap
    // -------------------------------
    public int findKthLargest(int[] nums, int k) {
        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        while (k != 0) {
            ans = pq.poll();
            k = k - 1;
        }

        return ans;
    }

    // -------------------------------
    // Kth Largest using Quick Select
    // -------------------------------
    public int findKthLargestQuickSelect(int[] nums, int k) {
        int target = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1;
    }

    private int partition(int[] nums, int left, int right) {

        int pivot = nums[right];

        int i = left;

        for (int j = left; j < right; j++) {

            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);

        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // -------------------------------
    // Top K Frequent
    // -------------------------------
    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];

        Map<Integer, Integer> mp = new HashMap<>();

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b[1], a[1]);
        });

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : mp.keySet()) {
            pq.add(new Integer[] { key, mp.get(key) });
        }

        int i = 0;

        while (k != 0) {
            ans[i] = pq.poll()[0];
            k = k - 1;
            i = i + 1;
        }

        return ans;
    }

    // -------------------------------
    // Merge K Sorted Lists
    // -------------------------------
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode ans = null;
        ListNode prev = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });

        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            if (ans == null) {
                ans = node;
            } else {
                prev.next = node;
            }

            prev = node;

            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return ans;
    }

    // -------------------------------
    // Utility Functions
    // -------------------------------
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }

    // -------------------------------
    // Main Method
    // -------------------------------
    public static void main(String[] args) {

        Day06_PriorityQueue obj = new Day06_PriorityQueue();

        // Test 1 : Kth Largest using Heap
        int[] arr1 = {3, 2, 1, 5, 6, 4};

        System.out.println(
                "Kth Largest (Heap): "
                        + obj.findKthLargest(arr1, 2));

        // Test 2 : Kth Largest using Quick Select
        int[] arr2 = {3, 2, 1, 5, 6, 4};

        System.out.println(
                "Kth Largest (QuickSelect): "
                        + obj.findKthLargestQuickSelect(arr2, 2));

        // Test 3 : Top K Frequent
        int[] arr3 = {1, 1, 1, 2, 2, 3};

        System.out.println(
                "Top K Frequent: "
                        + Arrays.toString(obj.topKFrequent(arr3, 2)));

        // Test 4 : Merge K Sorted Lists

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode merged = obj.mergeKLists(lists);

        System.out.print("Merged List: ");
        printList(merged);
    }
}