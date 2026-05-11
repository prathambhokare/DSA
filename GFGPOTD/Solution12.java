import java.util.*;

public class Solution12 {

    public static boolean isPalindrome(String str) {
        int i=0;
        int j=str.length()-1;
        while (i<j) {
            if (str.charAt(i)==str.charAt(j)) {
                i=i+1;
                j=j-1;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static boolean palindromePair(String[] arr) {
        // Code here
        boolean ans=false;
        Map<String,Integer> mp=new HashMap<>();//__store reverse value of each string
        for (int i=0;i<arr.length;i++) {
            String revval=new StringBuilder(arr[i]).reverse().toString();
            mp.put(revval,i);
        }
        for (int i=0;i<arr.length;i++) {
            String left="";
            for (int j=0;j<arr[i].length();j++) {
                left=left+arr[i].charAt(j);
                String right=arr[i].substring(j+1);
                if (!left.isEmpty() && isPalindrome(left)
                    && mp.containsKey(right)
                    && mp.get(right) != i) {
                    ans=true;
                    return ans;
                }

                if (isPalindrome(right)
                    && mp.containsKey(left)
                    && mp.get(left) != i) {
                    ans=true;
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean ans=palindromePair(new String[]{
            "geekf", "geeks", "or", "keeg", "abc", "bc"
        });
        System.out.println(ans);
    }
}
