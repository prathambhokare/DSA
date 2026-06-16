package DSA_Refrehser;

import java.util.*;

public class Day15_DSU {

    // ===================== DSU =====================
    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pb] = pa;
            }
        }
    }

    // ===================== 1. Accounts Merge =====================
    static class AccountsMergeSolution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int n = accounts.size();
            DSU dsu = new DSU(n);

            Map<String, Integer> emailToIndex = new HashMap<>();

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    String email = accounts.get(i).get(j);

                    if (!emailToIndex.containsKey(email)) {
                        emailToIndex.put(email, i);
                    } else {
                        dsu.union(i, emailToIndex.get(email));
                    }
                }
            }

            Map<Integer, List<String>> rootToEmails = new HashMap<>();

            for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
                String email = entry.getKey();
                int root = dsu.find(entry.getValue());

                rootToEmails
                        .computeIfAbsent(root, k -> new ArrayList<>())
                        .add(email);
            }

            List<List<String>> result = new ArrayList<>();

            for (Map.Entry<Integer, List<String>> entry : rootToEmails.entrySet()) {
                int root = entry.getKey();
                List<String> emails = entry.getValue();
                Collections.sort(emails);

                List<String> merged = new ArrayList<>();
                merged.add(accounts.get(root).get(0));
                merged.addAll(emails);

                result.add(merged);
            }

            return result;
        }
    }

    // ===================== 2. Number of Provinces =====================
    static class ProvincesSolution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            DSU dsu = new DSU(n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        dsu.union(i, j);
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(dsu.find(i));
            }

            return set.size();
        }
    }

    // ===================== 3. Redundant Connection =====================
    static class RedundantConnectionSolution {
        public int[] findRedundantConnection(int[][] edges) {
            DSU dsu = new DSU(2001); // safe size

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                if (dsu.find(u) == dsu.find(v)) {
                    return edge;
                }
                dsu.union(u, v);
            }

            return new int[]{};
        }
    }

    // ===================== MAIN TEST CASES =====================
    public static void main(String[] args) {

        // -------- Accounts Merge --------
        AccountsMergeSolution am = new AccountsMergeSolution();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "a@mail.com", "b@mail.com"));
        accounts.add(Arrays.asList("John", "b@mail.com", "c@mail.com"));
        accounts.add(Arrays.asList("Mary", "x@mail.com"));

        System.out.println("Accounts Merge:");
        System.out.println(am.accountsMerge(accounts));

        // -------- Provinces --------
        ProvincesSolution ps = new ProvincesSolution();

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println("\nNumber of Provinces:");
        System.out.println(ps.findCircleNum(isConnected));

        // -------- Redundant Connection --------
        RedundantConnectionSolution rc = new RedundantConnectionSolution();

        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}
        };

        System.out.println("\nRedundant Connection:");
        System.out.println(Arrays.toString(rc.findRedundantConnection(edges)));
    }
}
