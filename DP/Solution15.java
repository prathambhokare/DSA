package DP;

import java.util.ArrayList;
import java.util.List;

public class Solution15 {

    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while (i<j) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i=i+1;
            j=j-1;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<List<String>>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<String>> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                String part = s.substring(j, i + 1);
                if (!isPalindrome(part)) {
                    continue;
                }
                if (j == 0) {
                    List<String> temp = new ArrayList<>();
                    temp.add(part);
                    curr.add(temp);

                } else {
                    for (List<String> prev : dp.get(j - 1)) {
                        List<String> temp = new ArrayList<>(prev);
                        temp.add(part);
                        curr.add(temp);
                    }
                }
            }
            dp.add(curr);
        }
        return dp.get(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}
