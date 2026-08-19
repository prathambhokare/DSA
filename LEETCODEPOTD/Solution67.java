package LEETCODEPOTD;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution67 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];
            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }
            map.get(row).add(seat);
        }
        ans = (n - map.size()) * 2;
        for (int row : map.keySet()) {
            boolean slot1 = true; // 2,3,4,5
            boolean slot2 = true; // 4,5,6,7
            boolean slot3 = true; // 6,7,8,9
            for (int seat : map.get(row)) {
                if (seat == 2 || seat == 3 || seat == 4 || seat == 5) {
                    slot1 = false;
                }
                if (seat == 4 || seat == 5 || seat == 6 || seat == 7) {
                    slot2 = false;
                }
                if (seat == 6 || seat == 7 || seat == 8 || seat == 9) {
                    slot3 = false;
                }
            }
            if (slot1 && slot3) {
                ans += 2;
            }
            else if (slot1 || slot2 || slot3) {
                ans += 1;
            }
        }
        return ans;
    }
}
