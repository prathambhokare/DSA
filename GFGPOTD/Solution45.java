import java.util.*;

public class Solution45 {

    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int size) {
            n = size;
            tree = new int[4 * n];
        }

        void update(int node, int start, int end, int idx) {
            if (start == end) {
                tree[node]++;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid)
                update(2 * node, start, mid, idx);
            else
                update(2 * node + 1, mid + 1, end, idx);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return 0;

            if (l <= start && end <= r)
                return tree[node];

            int mid = (start + end) / 2;

            return query(2 * node, start, mid, l, r)
                    + query(2 * node + 1, mid + 1, end, l, r);
        }
    }

    public int countSubstring(String s) {

        int n = s.length();

        // Step 1: Prefix sums
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '1')
                prefix[i] = prefix[i - 1] + 1;
            else
                prefix[i] = prefix[i - 1] - 1;
        }

        // Step 2: Coordinate Compression
        int[] temp = prefix.clone();
        Arrays.sort(temp);

        Map<Integer, Integer> rank = new HashMap<>();

        int idx = 1;
        for (int x : temp) {
            if (!rank.containsKey(x)) {
                rank.put(x, idx++);
            }
        }

        SegmentTree st = new SegmentTree(idx);

        long ans = 0;

        // Step 3: Process prefixes
        for (int x : prefix) {

            int r = rank.get(x);

            // Count previous prefix sums < current prefix sum
            if (r > 1)
                ans += st.query(1, 1, idx - 1, 1, r - 1);

            // Insert current prefix
            st.update(1, 1, idx - 1, r);
        }

        return (int)ans;
    }
}
