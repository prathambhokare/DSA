package LEETCODEPOTD;

import java.util.*;

public class Solution26 {

    //     public boolean isPossibleToPlaceBlock(int x,int sz,Map<Integer,Integer> mp) {

//         int prev=0;
//         for (Integer key : mp.keySet()) {
//             // System.out.print(prev + " " + key + " ");
//             if (key>=x) {
//                 break;
//             }
//             if ((key-prev)>=sz) {
//                 return true;
//             }
//             prev=key;
//         }
//         // System.out.print(prev + " " + x + " ");
//         if ((x-prev)>=sz) {
//             return true;
//         }
//         // System.out.println();
//         return false;
//     }
//     public List<Boolean> getResults(int[][] queries) {
//         List<Boolean> ans=new ArrayList<>();
//         Map<Integer,Integer> mp=new TreeMap<>();
//         for (int i=0;i<queries.length;i++) {
//             if (queries[i][0]==1) {
//                 mp.put(queries[i][1],i);
//             }
//             else {
//                 ans.add(isPossibleToPlaceBlock(queries[i][1],queries[i][2],mp));
//             }
//         }
//         return ans;
//     }
// }

    static class SegmentTree {
        int n;
        int[] tree;
        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }
        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }
        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }
            int mid = (l + r) / 2;
            if (idx <= mid)
                update(node * 2, l, mid, idx, val);
            else
                update(node * 2 + 1, mid + 1, r, idx, val);

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        private int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || r < ql)
                return 0;
            if (ql <= l && r <= qr)
                return tree[node];
            int mid = (l + r) / 2;
            return Math.max(
                    query(node * 2, l, mid, ql, qr),
                    query(node * 2 + 1, mid + 1, r, ql, qr)
            );
        }
    }

    public static List<Boolean> getResults(int[][] queries) {
        int MAX = 50000;
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        // add all obstacles first
        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }
        SegmentTree seg = new SegmentTree(MAX + 1);
        Integer prev = null;
        for (int x : obstacles) {
            if (prev != null) {
                seg.update(x, x - prev);
            }
            prev = x;
        }
        List<Boolean> answer = new ArrayList<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];
            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];
                Integer lastObs = obstacles.floor(x);
                int bestGap = seg.query(0, x);
                bestGap = Math.max(bestGap, x - lastObs);
                answer.add(bestGap >= sz);
            } else {
                int pos = q[1];
                Integer left = obstacles.lower(pos);
                Integer right = obstacles.higher(pos);
                obstacles.remove(pos);
                if (right != null) {
                    seg.update(right, right - left);
                }
                seg.update(pos, 0);
            }
        }
        Collections.reverse(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[][] queries = {
            {1,2},
            {2,3,3},
            {2,3,1},
            {2,2,2}
        };
        List<Boolean> ans = getResults(queries);
        System.out.println(ans);
    }
}
