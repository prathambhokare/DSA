package SegmentTree;

public class MinRangeQuery {

    static int[] segmentTree;

    public MinRangeQuery() {

    }

    public MinRangeQuery(int size) {
        segmentTree = new int[4 * size];
    }

    public void buildSegmentTree(int root, int l, int r, int[] arr) {

        // __reach to leaf node
        if (l == r) {
            segmentTree[root] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        buildSegmentTree(2 * root + 1, l, mid, arr);
        buildSegmentTree(2 * root + 2, mid + 1, r, arr);

        segmentTree[root] = Math.min(segmentTree[2 * root + 1], segmentTree[2 * root + 2]);
    }

    public void updateSegmentTree(int root, int l, int r, int idx, int val, int[] arr) {

        // __reach to leaf node
        if (l == r) {
            segmentTree[root] = val;
            return;
        }

        int mid = (l + r) / 2;

        // __find position of idx
        if (mid >= idx) {
            // __present on left side
            updateSegmentTree(2 * root + 1, l, mid, idx, val, arr);
        } else {
            // __present on right side
            updateSegmentTree(2 * root + 2, mid + 1, r, idx, val, arr);
        }

        segmentTree[root] = Math.min(segmentTree[2 * root + 1], segmentTree[2 * root + 2]);
    }

    public int querySegmentTree(int root, int l, int r, int ql, int qr) {

        // __no overlap
        if (r < ql || qr < l) {
            return Integer.MAX_VALUE;
        }

        // __complete overlap
        if (ql <= l && r <= qr) {
            return segmentTree[root];
        }

        int mid = (l + r) / 2;

        return Math.min(
                querySegmentTree(2 * root + 1, l, mid, ql, qr),
                querySegmentTree(2 * root + 2, mid + 1, r, ql, qr));
    }

    public static void main(String[] args) {

        int[] arr = { 5, 2, 8, 1, 9, 3 };

        MinRangeQuery st = new MinRangeQuery(arr.length);

        st.buildSegmentTree(0, 0, arr.length - 1, arr);

        System.out.println("Original Array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Query [1,4]
        int ans1 = st.querySegmentTree(0, 0, arr.length - 1, 1, 4);
        System.out.println("Min in range [1,4] = " + ans1);

        // Query [0,2]
        int ans2 = st.querySegmentTree(0, 0, arr.length - 1, 0, 2);
        System.out.println("Min in range [0,2] = " + ans2);

        // Update index 3 from 1 -> 6
        st.updateSegmentTree(0, 0, arr.length - 1, 3, 6, arr);
        arr[3] = 6;

        System.out.println("\nAfter updating index 3 to 6:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        int ans3 = st.querySegmentTree(0, 0, arr.length - 1, 1, 4);
        System.out.println("Min in range [1,4] = " + ans3);

        int ans4 = st.querySegmentTree(0, 0, arr.length - 1, 0, 5);
        System.out.println("Min in entire array = " + ans4);
    }
}
