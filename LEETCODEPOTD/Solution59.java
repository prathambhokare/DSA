package LEETCODEPOTD;

import java.util.HashMap;
import java.util.Map;

public class Solution59 {
    public int minimumPushes(String word) {
        int ans=0;
        Map<Character,Integer> mp=new HashMap<>();
        int round=8;
        int push=1;
        for (int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if (mp.containsKey(ch)) {
                ans += mp.get(ch);
                continue;
            }
            mp.put(ch, push);
            ans += push;
            round--;
            if (round == 0) {
                round = 8;
                push++;
            }
        }
        return ans;
    }
}
