import java.util.Arrays;
import java.util.List;

public class Solution36 {
    
    public static int maxArea(List<Integer> height) {
        // code here
        int ans=0;
        int i=0;
        int j=height.size()-1;
        while (i<j) {
            ans=Math.max(ans,Math.min(height.get(i),height.get(j))*(j-i-1));
            if (height.get(i)<height.get(j)) {
                i=i+1;
            }
            else {
                j=j-1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int ans=maxArea(Arrays.asList(2,5,4,3,7));
        System.out.println(ans);
    }
}
