package Stack;

import java.util.*;

public class Solution1 {

    public static boolean generateParenthesis(int i,String s,int open,Boolean[][] dp) {

        if (i==s.length()) {
            return open==0;
        }

        if (dp[i][open]!=null) {
            return dp[i][open];
        }
        
        boolean ans=false;
        if (s.charAt(i)=='*') {
            if (generateParenthesis(i+1, s, open, dp)) {
                ans=true;
            }
            if (!ans && generateParenthesis(i+1, s, open+1, dp)) {
                ans=true;
            }
            if (!ans && open>0 && generateParenthesis(i+1, s, open-1, dp)) {
                ans=true;
            }
        }
        else if (s.charAt(i)=='(') {
            ans=generateParenthesis(i+1, s, open+1, dp);
        }
        else {
            if (open>0) {
                ans=generateParenthesis(i+1, s, open-1, dp);
            }
        }
        return dp[i][open]=ans;
    }

    public static boolean checkValidString(String s) {
        
        boolean ans=false;
        Boolean[][] dp=new Boolean[s.length()+1][s.length()+1];
        ans=generateParenthesis(0,s,0,dp);
        return ans;
    }

    public static void main(String[] args) {
        boolean ans=checkValidString("()");
        System.out.println(ans);
    }
}
