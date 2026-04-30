import java.util.*;
import java.util.*;
import java.io.*;

public class Solution6 {
    public static long getValue(long y, long x) {
        long n = Math.max(x, y);
        if (n % 2 == 1) {  // odd layer
            if (x == n) return n*n - (y-1);      
            else        return (n-1)*(n-1) + x;  
        } else {            // even layer
            if (x == n) return (n-1)*(n-1) + y;  
            else        return n*n - (x-1);      
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            sb.append(getValue(y, x)).append('\n');
        }
        System.out.print(sb);
    }
}