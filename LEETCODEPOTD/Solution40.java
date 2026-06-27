package LEETCODEPOTD;

import java.util.HashMap;
import java.util.Map;

public class Solution40 {

    public static int maximumLength(int[] nums) {
        int ans = 1;
        Map<Long, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put((long)x, cnt.getOrDefault((long)x,0)+1);
        }
        if (cnt.containsKey(1L)) {
            int c = cnt.get(1L);
            ans = Math.max(ans, (c % 2 == 0) ? c-1 : c);
        }
        for (long start : cnt.keySet()) {
            if (start == 1) continue;
            long x = start;
            int len = 0;
            while (cnt.getOrDefault(x,0) >= 2) {
                len += 2;
                if (x > 1000000000L / x)
                    break;
                x *= x;
            }
            if (cnt.getOrDefault(x,0) == 1)
                len++;
            else
                len--;

            ans = Math.max(ans,len);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=maximumLength(new int[]{5,4,1,2,2});
        System.out.println(ans);
    }
}
