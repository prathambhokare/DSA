import java.util.*;

public class Solution6 {
    
    public static boolean isPalindrome(String binaryString) {
        int i=0;
        int j=binaryString.length()-1;
        while (i<j) {
            if (binaryString.charAt(i)!=binaryString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean isBinaryPalindrome(int n) {
        // code here
        String binaryString=Integer.toBinaryString(n);
        if (!isPalindrome(binaryString)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = isBinaryPalindrome(17);
        System.out.println(ans);
    }
}
