public class Solution {
    boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        k = isPowerOfTwo(n) ? k / 2 : k * 2;
        if (k > n) return "-1";
        if (k == 0) return s; 
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            while (k > 0 &&
                   stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        return stack.length() == 0 ? "-1" : stack.toString();
    }