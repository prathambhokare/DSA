package DSA_Refrehser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Day14_TopologicalSort {

    // =====================================================
    // Alien Dictionary (GFG)
    // =====================================================
    public String findOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Add all unique characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            // Invalid prefix case
            if (w1.length() > w2.length() &&
                    w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {

                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2,
                                indegree.get(c2) + 1);
                    }

                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!queue.isEmpty()) {

            char node = queue.poll();
            ans.append(node);

            for (char child : graph.get(node)) {

                indegree.put(child,
                        indegree.get(child) - 1);

                if (indegree.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }

        if (ans.length() != indegree.size()) {
            return "";
        }

        return ans.toString();
    }

    // =====================================================
    // Course Schedule (Leetcode 207)
    // =====================================================
    public boolean canFinish(int numCourses,
                             int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph =
                new HashMap<>();

        for (int[] pre : prerequisites) {

            int a = pre[0];
            int b = pre[1];

            indegree[a]++;

            graph.computeIfAbsent(
                    b,
                    k -> new ArrayList<>()
            ).add(a);
        }

        Queue<Integer> queue =
                new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            processed++;

            for (int child :
                    graph.getOrDefault(
                            node,
                            new ArrayList<>())) {

                indegree[child]--;

                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }

        return processed == numCourses;
    }

    // =====================================================
    // Course Schedule II (Leetcode 210)
    // =====================================================
    public int[] findOrder(int numCourses,
                           int[][] prerequisites) {

        int[] indegree =
                new int[numCourses];

        Map<Integer, List<Integer>> graph =
                new HashMap<>();

        for (int[] pre : prerequisites) {

            int a = pre[0];
            int b = pre[1];

            indegree[a]++;

            graph.computeIfAbsent(
                    b,
                    k -> new ArrayList<>()
            ).add(a);
        }

        Queue<Integer> queue =
                new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            order[idx++] = node;

            for (int child :
                    graph.getOrDefault(
                            node,
                            new ArrayList<>())) {

                indegree[child]--;

                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }

        if (idx != numCourses) {
            return new int[]{};
        }

        return order;
    }


    public static void main(String[] args) {

        Day14_TopologicalSort sol = new Day14_TopologicalSort();

        // =====================================================
        // 1. Alien Dictionary
        // =====================================================
        System.out.println("===== Alien Dictionary =====");

        String[] words1 = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println("Order: " + sol.findOrder(words1));

        String[] words2 = {"caa", "aaa", "aab"};
        System.out.println("Order: " + sol.findOrder(words2));

        String[] words3 = {"abc", "ab"};
        System.out.println("Order: " + sol.findOrder(words3));

        // =====================================================
        // 2. Course Schedule (Leetcode 207)
        // =====================================================
        System.out.println("\n===== Course Schedule =====");

        int numCourses1 = 2;
        int[][] prereq1 = {
                {1, 0}
        };

        System.out.println(
                "Can Finish: " +
                        sol.canFinish(numCourses1, prereq1)
        );

        int numCourses2 = 2;
        int[][] prereq2 = {
                {1, 0},
                {0, 1}
        };

        System.out.println(
                "Can Finish: " +
                        sol.canFinish(numCourses2, prereq2)
        );

        // =====================================================
        // 3. Course Schedule II (Leetcode 210)
        // =====================================================
        System.out.println("\n===== Course Schedule II =====");

        int numCourses3 = 4;
        int[][] prereq3 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        System.out.println(
                "Order: " +
                        Arrays.toString(
                                sol.findOrder(numCourses3, prereq3)
                        )
        );

        int numCourses4 = 2;
        int[][] prereq4 = {
                {1, 0},
                {0, 1}
        };

        System.out.println(
                "Order: " +
                        Arrays.toString(
                                sol.findOrder(numCourses4, prereq4)
                        )
        );
    }
}
