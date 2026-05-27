package DSA_Refrehser;

import java.util.*;

public class Day01_SlindingWindow {
    
    public static int lenghtOfLongestSubstring(String s) {
        int ans=0;
        Map<Character,Integer> mp=new HashMap<>();
        int j=0;
        for (int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if (mp.containsKey(ch)) {
                j = Math.max(j, mp.get(ch) + 1);
            }
            mp.put(ch,i);
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }

    public static int longestOnes(int[] nums,int k) {
        int ans=0;
        int i=0;
        int j=0;
        int cntZero=0;
        while (j<nums.length) {
            if (nums[j]==0) {
                cntZero=cntZero+1;
            }
            while (cntZero>k) {
                if (nums[i]==0) {
                    cntZero=cntZero-1;
                }
                i=i+1;
            }
            ans=Math.max(ans, j-i+1);
            j=j+1;
        }
        return ans;
    }

    public static boolean isValidWindow(Map<Character,Integer> mp) {
        for (Character key : mp.keySet()) {
            if (mp.containsKey(key) && mp.get(key)>0) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow(String s,String t) {
        String ans=s+t;
        Map<Character,Integer> mp=new HashMap<>();
        for (int i=0;i<t.length();i++) {
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)+1);
        }
        int count=t.length();
        int i=0;
        int j=0;
        while (j<s.length()) {
            char ch=s.charAt(j);
            if (mp.containsKey(ch)) {
                System.out.println(mp.get(ch));
                mp.put(ch,mp.get(ch)-1);
            }
            while (isValidWindow(mp)) {
                ch=s.charAt(i);
                if (mp.containsKey(ch)) {
                    mp.put(ch,mp.get(ch)+1);
                }
                if (ans.length()>(j-i+1)) {
                    // System.out.println(i + " " + j);
                    ans=s.substring(i, j+1);
                } 
                i=i+1;
            }
            j=j+1;
        }
        if (ans.equals(s+t)) {
            ans="";
            return ans;
        }
        return ans;
    }



    public static void main(String[] args) {
        // int ans=lenghtOfLongestSubstring("abba");
        // System.out.println(ans);
        // int ans=longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
        // System.out.println(ans);
        String ans=minWindow("ADOBECODEBANC", "ABC");
        System.out.println(ans);
    }
}
