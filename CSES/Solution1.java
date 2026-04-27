import java.util.*;

public class Solution1 {
    public static void weiredAlgorithm(long n) {
        System.out.print(n + " ");
        if (n==1) {
            return;
        }
        if (n%2==0) {
            weiredAlgorithm(n/2);
        }
        else {
            weiredAlgorithm(n*3+1);
        }
        return;
        //Thanks Swami For Helping Me Out
    }
    public static void main(String[] args) {
        long n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        weiredAlgorithm(n);
    }
}
