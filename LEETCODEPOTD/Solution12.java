package LEETCODEPOTD;

import java.util.Arrays;

public class Solution12 {
    
    public static boolean isPossible(int[][] tasks,int threshold) {
        boolean ans=true;
        for (int i=0;i<tasks.length;i++) {
            if (threshold>=tasks[i][1]) {
                threshold=threshold-tasks[i][0];
            }
            else {
                ans=false;
                break;
            }
        }
        return ans;
    }
    public static int minimumEffort(int[][] tasks) {
        //This Problem Can Be Solved By Using Binary Search
        //__Let's Check What is Maximum Amount Of Energy Required
        //1.Find out min and max min. amount of energy required to begin ith task
        //2.Then Run Binary Search On Answer Query To Find Minimum Initial Amount Required
        int ans=0;
        int minEnergy=Integer.MAX_VALUE;
        int maxEnergy=0; 
        for (int i=0;i<tasks.length;i++) {
            minEnergy=Math.min(minEnergy,tasks[i][1]);
            maxEnergy=maxEnergy+tasks[i][1];
        }
        Arrays.sort(tasks,(a,b)->{
            return Math.abs(b[1]-b[0])-Math.abs(a[1]-a[0]);
        });
        while (minEnergy<=maxEnergy) {
            int possibleInitialEnergy=(maxEnergy+minEnergy)/2;
            if (isPossible(tasks,possibleInitialEnergy)) {
                ans=possibleInitialEnergy;
                maxEnergy=possibleInitialEnergy-1;
            }
            else {
                minEnergy=possibleInitialEnergy+1;
            }
        }
        return ans;   
    }

    public static void main(String[] args) {
        int ans=minimumEffort(new int[][] {
            {1,2},
            {2,4},
            {4,8}
        });
        System.out.println(ans);
    }
}
