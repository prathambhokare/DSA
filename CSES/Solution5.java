import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        if (n!=1 && n <= 3) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (long i = 2; i <= n; i += 2) sb.append(i).append(' ');
        for (long i = 1; i <= n; i += 2) sb.append(i).append(' ');

        System.out.println(sb);
    }
}
