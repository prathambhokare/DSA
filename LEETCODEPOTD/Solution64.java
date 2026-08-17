package LEETCODEPOTD;

public class Solution64 {

    public static int countAfterErase(String s) {
        if (s.length()==0 || s.length()==1) {
            return 0;
        }
        if (s.length()==2) {
            return 0;
        }
        return 2 + countAfterErase(s.substring(0, 2)) + 
                   countAfterErase(s.substring(2));
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        int ans=0;
        ans=countAfterErase("aaaaa");
        System.out.println(ans);
    }   
}
