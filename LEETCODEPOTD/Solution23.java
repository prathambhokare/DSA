package LEETCODEPOTD;

import java.util.HashSet;
import java.util.Set;

public class Solution23 {
    
    public static int numberOfSpecialChars(String word) {
        int ans=0;
        Set<Character> set=new HashSet<>();
        for (int i=0;i<word.length();i++) {
            if (word.charAt(i)>='a' && word.charAt(i)<='z') {
                continue;
            }
            set.add(word.charAt(i));
        }
        Set<Character> visited=new HashSet<>();
        for (int i=0;i<word.length();i++) {
            if (set.contains((char)(word.charAt(i)-'a'+'A')) && !visited.contains(word.charAt(i))) {
                ans=ans+1;
            }
            visited.add(word.charAt(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=numberOfSpecialChars("aaAbcBC");
        System.out.println(ans);
    }
}
