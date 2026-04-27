import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution4 {
    public static long minimumNOMoves(long[] nums) {
        long ans=0;
        for (int i=1;i<nums.length;i++) {
            long diff=nums[i]-nums[i-1];
            if (diff<0) {
                nums[i]=nums[i]-diff;
                ans=ans-diff;
            }
            // System.out.println(nums[i]);
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(minimumNOMoves(nums));
    }
}
