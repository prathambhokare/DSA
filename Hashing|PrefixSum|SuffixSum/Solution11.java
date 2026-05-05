import java.util.*;

public class Solution11 {

    static class Pair {
        public char ch;
        public int count;
        public Pair(char ch,int count) {
            this.ch=ch;
            this.count=count;
        }
    }
    
    public static char goodCharacter(String str) {
        Map<Character,Integer> mp=new HashMap<>();
        for (int i=0;i<str.length();i++) {
            mp.put(str.charAt(i),mp.getOrDefault(str.charAt(i), 0) + (i+1)*(str.length()-i));
        }
        Pair[] pair=new Pair[mp.size()];
        int i=0;
        for (Character key : mp.keySet()) {
            pair[i]=new Pair(key,mp.get(key));
            i=i+1;
        }
        Arrays.sort(pair,(a,b)->{
            if (a.count!=b.count) {
                return b.count-a.count;
            }
            return a.ch-b.ch;
        });
        return pair[0].ch;
    }
    public static void main(String[] args) {
        char ans = goodCharacter("abca");
        System.out.println(ans);
    }
}
