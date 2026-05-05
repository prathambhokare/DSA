import java.util.*;

public class Solution9 {

    public static int countGoodBinaryStrings(String binaryString) {
        int ans=0;
        int countZeroOne=0;
        int countOneZero=0;
        // 10100
        for (int i=0;i<binaryString.length();i++) {
            if (binaryString.charAt(i)=='1') {
                if ((i-1)>=0 && binaryString.charAt(i-1)=='0') {
                    countZeroOne=countZeroOne+1;
                }
                if ((i+1)<binaryString.length() && binaryString.charAt(i+1)=='0') {
                    countOneZero=countOneZero+1;
                }
            }
        }
        // System.out.println(countZeroOne + " " +countOneZero );
        if (countZeroOne==0 && countOneZero==0) {
            return binaryString.length()/2+1;
        }
        //__countZeroOne -> 1
        //__countOneZero -> 2
        //__ 
        for (int i=0;i<binaryString.length();i++) {
            //__calculate impact of flip's at index i
            int currCountZeroOne=0;
            int currCountOneZero=0;
            if (binaryString.charAt(i)=='1') {
                if ((i-1)>=0 && binaryString.charAt(i-1)=='0') {
                    currCountZeroOne=currCountZeroOne+1;
                }
                if ((i+1)<binaryString.length() && binaryString.charAt(i+1)=='0') {
                    currCountOneZero=currCountOneZero+1;
                }
                // System.out.println(currCountZeroOne + " " + currCountOneZero);
                if (countZeroOne-currCountZeroOne==countOneZero-currCountOneZero) {
                    ans=ans+1;
                }
            }
            else {
                if ((i-1)>=0 && binaryString.charAt(i-1)=='0') {
                    currCountZeroOne=currCountZeroOne+1;
                }
                if ((i+1)<binaryString.length() && binaryString.charAt(i+1)=='0') {
                    currCountOneZero=currCountOneZero+1;
                }
                // System.out.println(currCountZeroOne + " " + currCountOneZero);
                if (countZeroOne+currCountZeroOne==countOneZero+currCountOneZero) {
                    ans=ans+1;
                }
            }
        }
        return ans;
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t != 0) {
            String s = sc.nextLine();
            int ans = countGoodBinaryStrings(s);
            System.out.println(ans);
            t--;
        }
    }
}
