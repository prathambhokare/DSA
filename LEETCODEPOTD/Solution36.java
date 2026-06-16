package LEETCODEPOTD;

public class Solution36 {
    public String reverse(String result) {
        String ans="";
        for (int i=result.length()-1;i>=0;i--) {
            ans=ans+result.charAt(i);
        }
        return ans;
    }
    public String processStr(String s) {
        String result="";
        for (int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if (ch=='*') {
                if (result.length()>0) {
                    result=result.substring(0,result.length()-1);
                }
            }
            else if (ch=='#') {
                result=result+result;
            }
            else if (ch=='%') {
                result=reverse(result);
            }
            else {
                result=result+ch;
            }
        }
        return result;
    }
}
