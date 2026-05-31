package LEETCODEPOTD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution27 {

    public static int getPosition(List<Integer> list,long mass) {
        int ans=-1;
        int i=0;
        int j=list.size()-1;
        while (i<=j) {
            int mid=i+(j-i)/2;
            if (list.get(mid)<=mass) {
                ans=mid;
                i=mid+1;
            }
            else {
                j=mid-1;
            }
        }
        return ans;
    }
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        List<Integer> list=new ArrayList<>();
        long currentMass=mass;
        for (int i=0;i<asteroids.length;i++) {
            list.add(asteroids[i]);
        }
        Collections.sort(list);
        for (int i=0;i<asteroids.length;i++) {
            int idx=getPosition(list,currentMass);
            if (idx==-1) {
                return false;
            }
            currentMass=currentMass+list.get(idx);
            list.remove(idx);
            // System.out.println(mass + " " + list);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans=asteroidsDestroyed(10, new int[]{3,9,19,5,21});
        System.out.println(ans);
    }
}
