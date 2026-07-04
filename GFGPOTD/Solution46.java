import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution46 {
    public int maxCharGap(String s) {
        // code here
        int ans=-1;
        Map<Character,List<Integer>> mp=new HashMap<>();
        for (int i=0;i<s.length();i++) {
            List<Integer> list=mp.getOrDefault(s.charAt(i),new ArrayList<>());
            list.add(i);
            mp.put(s.charAt(i),list);
        }
        for (Character key:mp.keySet()) {
            List<Integer> valuesList=mp.getOrDefault(
                key,new ArrayList<>());
                if (valuesList.size()>1) {
                    Collections.sort(valuesList);
                    ans=Math.max(ans,valuesList.get(valuesList.size()-1)-
                    valuesList.get(0)-1);
                }
        }
        return ans;
    }
}
