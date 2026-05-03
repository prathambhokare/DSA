package LEETCODEPOTD;

import java.util.*;

public class Solution3 {

    public static boolean rotateString(String s, String goal) {
        boolean ans=false;
        String ansVal=s+s;
        if (s.length()!=goal.length()) {
            return ans;
        }
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)==goal.charAt(0)) {
                // System.out.println(ansVal.substring(i,i+goal.length()));
                if (ansVal.substring(i,i+goal.length()).equalsIgnoreCase(goal)) {
                    ans=true;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean ans=rotateString("abcde", "cdeab");
        System.out.println(ans);
    }
}
