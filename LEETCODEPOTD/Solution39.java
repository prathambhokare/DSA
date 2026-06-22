package LEETCODEPOTD;

import java.util.HashMap;
import java.util.Map;

public class Solution39 {

    public static int maxNumberOfBalloons(String text) {
        int ans=0;
        Map<Character,Integer> mp=new HashMap<>();
        for (int i=0;i<text.length();i++) {
            char ch=text.charAt(i);
            if (ch=='b' || ch=='a' || ch=='l' || ch=='l' || ch=='o' || ch=='o' || ch=='n') {
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }
        }
        String balloon="balloon";
        while (true) {
            for (int i=0;i<balloon.length();i++) {
                char ch=balloon.charAt(i);
                if (!mp.containsKey(ch)) {
                    return ans;
                }
                if (mp.get(ch)>0) {
                    if (mp.get(ch)-1!=0) {
                        mp.put(ch,mp.getOrDefault(ch,0)-1);
                    }
                    else {
                        mp.remove(ch);
                    }
                }
            }
            ans=ans+1;
        }
    }

    public static void main(String[] args) {
        int ans=maxNumberOfBalloons("nlaebolko");
        System.out.println(ans);
    }
}
