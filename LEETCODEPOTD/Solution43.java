package LEETCODEPOTD;

import java.util.HashMap;
import java.util.Map;

public class Solution43 {
    public int numberOfSubstrings(String s) {
        int ans=0;
        // for (int i=0;i<s.length();i++) {
        //     Set<Character> set=new HashSet<>();
        //     for (int j=i;j<s.length();j++) {
        //         if (s.charAt(j)=='a' || s.charAt(j)=='b' || s.charAt(j)=='c') {
        //             set.add(s.charAt(j));
        //         }
        //         if (set.size()==3) {
        //             ans=ans+s.length()-j;
        //             break;
        //         }
        //     }
        //     if (set.size()!=3) {
        //         return ans;
        //     }
        // }
        int i=0;
        int j=0;
        Map<Character,Integer> mp=new HashMap<>();
        while (j<s.length()) {
            char ch=s.charAt(j);
            // System.out.println("=> == " + ch);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            if (mp.size()==3) {
                while (i<s.length() && mp.size()>=3) {
                    if (mp.get(s.charAt(i))-1==0) {
                        mp.remove(s.charAt(i));
                    }
                    else {
                        mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                    }
                    // System.out.println(s.charAt(i) + " => " + mp.get(s.charAt(i)));
                    ans=ans+s.length()-j;
                    i=i+1;
                    if (mp.size()<3) {
                        break;
                    }
                }
            }
            j=j+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}
