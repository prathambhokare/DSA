package LEETCODEPOTD;

import java.util.ArrayList;
import java.util.List;

public class Solution52 {
    public List<Integer> sequentialDigits(int low, int high) {
        // 12,23,34,45,56,67,78,89
        // 1234,2345,3456,4567,5678,6789,
        // 12345,23456,347
        List<Integer> ans = new ArrayList<>();
        List<String> sequentialDigits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            sequentialDigits.add(i + "");
        }
        while (!sequentialDigits.isEmpty()) {
            List<String> next = new ArrayList<>();
            for (int i = 0; i < sequentialDigits.size(); i++) {
                int val = Integer.parseInt(sequentialDigits.get(i));
                if (val >= low && val <= high) {
                    ans.add(val);
                }
                if (i + 1 < sequentialDigits.size()) {
                    next.add(
                        sequentialDigits.get(i)
                        + sequentialDigits.get(i + 1).charAt(
                            sequentialDigits.get(i + 1).length() - 1
                        )
                    );
                }
            }
            sequentialDigits = next;
        }
        return ans;
    }
}
