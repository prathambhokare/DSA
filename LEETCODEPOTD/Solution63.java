package LEETCODEPOTD;

import java.util.HashMap;
import java.util.Map;

public class Solution63 {
    public Map<String,Integer> mp=new HashMap<>();
    public String getKey(int idx,int m,boolean turn) {
        return idx+ " | " + m + " | " + turn;
    }
    public int maxStone(int idx,int[] piles,int m,boolean turn) {

        if (idx>=piles.length) {
            return 0;
        }

        String key=getKey(idx,m,turn);
        if (mp.containsKey(key)) {
            return mp.get(key);
        }

        if (turn) {
            int sum=Integer.MIN_VALUE;
            int ansval=0;
            for (int i=idx;i<=Math.min(piles.length-1,idx+2*m-1);i++) {   
                ansval=ansval+piles[i];
               sum=Math.max(sum,ansval+maxStone(i+1,piles,Math.max(i-idx+1,m),false));
            }
            mp.put(
                key,sum
            );
            return sum;
        }
        else {
            int sum=Integer.MAX_VALUE;
            for (int i=idx;i<=Math.min(piles.length-1,idx+2*m-1);i++) {   
               sum=Math.min(sum,0+maxStone(i+1,piles,Math.max(i-idx+1,m),true));
            }
            mp.put(
                key,sum
            );
            return sum;
        }
    }
    public int stoneGameII(int[] piles) {
       return maxStone(0,piles,1,true);
    }
}
