package LEETCODEPOTD;

public class Solution31 {

    public static int totalWavinessValue(int num) {
        int ans=0;
        String str=String.valueOf(num);
        for (int i=1;i<str.length()-1;i++) {
            //__check for mountain
            if (str.charAt(i-1)>str.charAt(i) && str.charAt(i)<str.charAt(i+1)) {
                ans=ans+1;
            }
            //__check for valley
            if (str.charAt(i-1)<str.charAt(i) && str.charAt(i)>str.charAt(i+1)) {
                ans=ans+1;
            }
        }
        return ans;
    }

    public static int totalWaviness(int num1, int num2) {
        int ans=0;
        for (int i=num1;i<=num2;i++) {
            ans=ans+totalWavinessValue(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=totalWaviness(120,130);
        System.out.println(ans);
    }
}
