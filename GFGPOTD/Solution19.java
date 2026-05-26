import java.util.*;

public class Solution19 {

    public static boolean wifiRange(String s, int x) {
        // code here
        boolean flag1=false;
        boolean flag2=false;
        if (s.length()==1) {
            if (s.charAt(0)=='0') {
                return false;
            }
            return true;
        }
        if (s.charAt(0)=='0') {
            flag1=true;
            s='1'+s;
        }
        if (s.charAt(s.length()-1)=='0') {
            flag2=true;
            s=s+'1';
        }
        int i=1;
        int cntZero=0;
        boolean firstOne=false;
        while (i<s.length()) {
            if (s.charAt(i)=='0') {
                cntZero=cntZero+1;
            }
            else {
                if (!firstOne && flag1) {
                    if (cntZero>x) {
                        return false;
                    }
                }
                else if (i==s.length()-1 && flag2) {
                    if (cntZero>x) {
                        return false;
                    }
                }
                else if (cntZero>2*x) {
                    return false;
                }
                firstOne=true;
                cntZero=0;
            }
            i=i+1;
        }
        return true;
    }
    public static void main(String[] args) {
        boolean ans=wifiRange("010", 0);
        System.out.println(ans);
    }
}
