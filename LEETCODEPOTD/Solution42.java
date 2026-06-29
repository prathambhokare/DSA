package LEETCODEPOTD;

import java.util.HashSet;
import java.util.Set;

public class Solution42 {
    public int numOfStrings(String[] patterns, String word) {
        int ans=0;
        Set<String> ansval=new HashSet<>();
        for (int i=0;i<word.length();i++) {
            String ansv="";
            for (int j=i;j<word.length();j++) {
                ansv=ansv+word.charAt(j);
                ansval.add(ansv);
            }
        }
        for (int i=0;i<patterns.length;i++) {
            if (ansval.contains(patterns[i])) {
                ans=ans+1;
            }
        }
        return ans;
    }
}
