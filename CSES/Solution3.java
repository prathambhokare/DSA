import java.util.*;

public class Solution3 {
    public static int longestSubstringWithSingleCharacter(String input,char ch) {
        int len=0;
        int maxLen=0;
        for (int i=0;i<input.length();i++) {
            char chval=input.charAt(i);
            if (chval==ch) {
                len=len+1;
            }
            else {
                len=0;
            }
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int ans=longestSubstringWithSingleCharacter(input,'A');
        ans=Math.max(ans,longestSubstringWithSingleCharacter(input,'C'));
        ans=Math.max(ans,longestSubstringWithSingleCharacter(input,'G'));
        ans=Math.max(ans,longestSubstringWithSingleCharacter(input,'T'));
        System.out.println(ans);
    }
}
