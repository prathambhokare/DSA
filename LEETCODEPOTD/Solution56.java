package LEETCODEPOTD;

import java.util.Stack;

public class Solution56 {
    public String smallestSubsequence(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        Stack<Character> st = new Stack<>();
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt[ch - 'a']--;
            if (visited[ch - 'a']) {
                continue;
            }
            while (!st.isEmpty()
                    && ch < st.peek()
                    && cnt[st.peek() - 'a'] > 0) {

                visited[st.peek() - 'a'] = false;
                st.pop();
                    }
            st.push(ch);
            visited[ch - 'a'] = true;
        }
        String ans = "";
        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;
    }
}
