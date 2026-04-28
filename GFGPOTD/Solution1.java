import java.util.*;

public class Solution1 {
    
    public static int longestSubstr(String s, int k) {
        int i=0;
        int j=0;
        int[] freq=new int[26];
        int maxFreq=0;
        int ans=0;
        while (i<s.length()) {
            freq[s.charAt(i)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(i)-'A']);
            int windowLength=i-j+1;
            int characterNeedsToChange=windowLength-maxFreq;
            if (characterNeedsToChange>k) {
                freq[s.charAt(i)-'A']--;
                j=j+1;
            }
            windowLength=i-j+1;
            ans=Math.max(ans, windowLength);
            i=i+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int k=sc.nextInt();
        int ans=longestSubstr(s,k);
        System.out.println(ans);
    }
}
