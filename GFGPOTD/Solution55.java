public class Solution55 {
    public int maxSubsetXOR(int[] arr) {

        int[] basis = new int[32];
        for (int num : arr) {
            int x = num;
            for (int bit = 31; bit >= 0; bit--) {
                if ((x & (1 << bit)) == 0) {
                    continue;
                }
                if (basis[bit] == 0) {
                    basis[bit] = x;
                    break;
                }
                x ^= basis[bit];
            }
        }

        int ans = 0;
        for (int bit = 31; bit >= 0; bit--) {
            if ((ans ^ basis[bit]) > ans) {
                ans ^= basis[bit];
            }
        }
        return ans;
    }
}
