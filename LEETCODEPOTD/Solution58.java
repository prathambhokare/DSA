package LEETCODEPOTD;

import java.util.HashMap;
import java.util.Map;

public class Solution58 {
    public String smallestPalindrome(String s) {
        String ans = "";
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder half = new StringBuilder();
        char mid = '#';
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (mp.containsKey(ch)) {
                int cnt = mp.get(ch);
                for (int i = 0; i < cnt / 2; i++) {
                    half.append(ch);
                }

                if (cnt % 2 == 1) {
                    mid = ch;
                }
            }
        }
        ans += half.toString();
        if (mid != '#') {
            ans += mid;
        }
        ans += half.reverse().toString();
        return ans;
    }
}
