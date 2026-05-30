package SegmentTree;

public class MaxRangeQuery {

    static int[] segmentTree;

    public MaxRangeQuery() {
        // constructor
    }

    public static void buildSegmentTree(int root, int l, int r, int[] arr) {

        if (l == r) {
            segmentTree[root] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        buildSegmentTree(2 * root + 1, l, mid, arr);
        buildSegmentTree(2 * root + 2, mid + 1, r, arr);

        segmentTree[root] = Math.max(
                segmentTree[2 * root + 1],
                segmentTree[2 * root + 2]

        );
    }

    public static void updateSegmentTree(int root, int l, int r, int idx, int val, int[] arr) {

        if (l == r) {
            segmentTree[root] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (mid < idx) {
            updateSegmentTree(2 * root + 2, mid + 1, r, idx, val, arr);
        } else {
            updateSegmentTree(2 * root + 1, l, mid, idx, val, arr);
        }

        segmentTree[root] = Math.max(segmentTree[2 * root + 1], segmentTree[2 * root + 2]);
    }

    public static int querySegmentTree(int root, int l, int r, int ql, int qr) {

        // __No OverLap
        if (qr < l || ql > r) {
            return Integer.MIN_VALUE;
        } // __Complete OverLap
        else if (l >= ql && qr >= r) {
            return segmentTree[root];
        }

        int mid = (l + r) / 2;
        return Math.max(
                querySegmentTree(2 * root + 1, l, mid, ql, qr),
                querySegmentTree(2 * root + 2, mid + 1, r, ql, qr));
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11 };
        int n = arr.length;

        segmentTree = new int[4 * n];

        buildSegmentTree(0, 0, n - 1, arr);

        System.out.println("Original Array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        int max1 = querySegmentTree(0, 0, n - 1, 1, 4);
        System.out.println("Max in range [1,4] = " + max1);

        updateSegmentTree(0, 0, n - 1, 2, 20, arr);
        arr[2] = 20;

        System.out.println("After updating index 2 to 20:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        int max2 = querySegmentTree(0, 0, n - 1, 1, 4);
        System.out.println("Max in range [1,4] = " + max2);

        int max3 = querySegmentTree(0, 0, n - 1, 0, n - 1);
        System.out.println("Max in entire array = " + max3);
    }
}
