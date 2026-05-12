package SegmentTree;

import java.lang.reflect.Array;
import java.util.*;

public class RangeLcmQueries {

    static long[] segmentTree;

    //__Build Segment Tree
    public static void buildSegmentTree(int root, int l, int r, int[] arr) {

        //__Leaf Node
        if (l == r) {
            segmentTree[root] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        buildSegmentTree(2 * root + 1, l, mid, arr);
        buildSegmentTree(2 * root + 2, mid + 1, r, arr);

        segmentTree[root] = lcm(
            segmentTree[2 * root + 1],
            segmentTree[2 * root + 2]
        );
    }

    //__Update Segment Tree
    public static void updateSegmenTree(int root, int l, int r, int idx, int val) {

        //__Leaf Node
        if (l == r) {
            segmentTree[root] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            updateSegmenTree(2 * root + 1, l, mid, idx, val);
        } else {
            updateSegmenTree(2 * root + 2, mid + 1, r, idx, val);
        }

        segmentTree[root] = lcm(
            segmentTree[2 * root + 1],
            segmentTree[2 * root + 2]
        );
    }

    //__Query Segment Tree
    public static long querySegmentTree(int root, int l, int r, int ql, int qr) {

        // SUM  -> identity = 0
        // MIN  -> identity = +INF
        // MAX  -> identity = -INF
        // GCD  -> identity = 0
        // LCM  -> identity = 1
        //__No Overlap
        if (ql > r || qr < l) {
            return 1;
        }

        //__Complete Overlap
        if (ql <= l && r <= qr) {
            return segmentTree[root];
        }

        int mid = (l + r) / 2;

        long left = querySegmentTree(
            2 * root + 1,
            l,
            mid,
            ql,
            qr
        );

        long right = querySegmentTree(
            2 * root + 2,
            mid + 1,
            r,
            ql,
            qr
        );

        return lcm(left, right);
    }

    //__GCD Function
    public static long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    //__LCM Function
    public static long lcm(long a, long b) {

        return (a * b) / gcd(a, b);
    }

    public static ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {

        ArrayList<Long> ans = new ArrayList<>();

        segmentTree = new long[4 * arr.length];

        //__Build Tree
        buildSegmentTree(0, 0, arr.length - 1, arr);

        for (int i = 0; i < queries.length; i++) {

            //__Update Query
            if (queries[i][0] == 1) {

                int idx = queries[i][1];
                int val = queries[i][2];

                updateSegmenTree(
                    0,
                    0,
                    arr.length - 1,
                    idx,
                    val
                );
            }

            //__Range Query
            else {

                int ql = queries[i][1];
                int qr = queries[i][2];

                long ansval = querySegmentTree(
                    0,
                    0,
                    arr.length - 1,
                    ql,
                    qr
                );

                ans.add(ansval);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Long> ans=RangeLCMQuery(new int[]{2,3,4,6,8,16},
            new int[][]{
                {2,0,2},
                {1,3,8},
                {2,2,5}
            }
        );
        for (int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
