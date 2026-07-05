import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution47 {
    public int maxPathSum(int[] a, int[] b) {
        // code here
        int ans=0;
        List<Integer> commonpoints=new ArrayList<>();
        Map<Integer,Integer> mp=new HashMap<>();
        int[] suma=new int[a.length];
        int[] sumb=new int[b.length];
        for (int i=0;i<a.length;i++) {
            suma[i]=suma[i]+(i-1)>=0?suma[i-1]:0;
            suma[i]=suma[i]+a[i];
            mp.put(a[i],i);
        }
        int j=-1;
        int k=-1;
        for (int i=0;i<b.length;i++) {
            sumb[i]=sumb[i]+(i-1)>=0?sumb[i-1]:0;
            sumb[i]=sumb[i]+b[i];
            if (mp.containsKey(b[i])) {
                ans=ans+Math.max(
                    (suma[mp.get(b[i])]-(j==-1?0:suma[j])),
                    (sumb[i]-(k==-1?0:sumb[k])));
                    j=mp.get(b[i]);
                    k=i;
                // System.out.println(i + " " + mp.get(b[i]) + " -> " + ans);
            }
        }
                ans=ans+Math.max(
                    (suma[a.length-1]-(j==-1?0:suma[j])),
                    (sumb[b.length-1]-(k==-1?0:sumb[k])));
        return ans;
    }
}
