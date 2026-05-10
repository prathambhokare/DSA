import java.util.*;

public class Solution11 {

    public static int maxProfit(int idx,int x,int y,int[] a,int[] b) {

        if (x==0 && y==0) {
            return 0;
        }

        if (idx>=a.length || idx>=b.length) {
            return 0;
        }

        if (x==0 && y!=0) {
            return a[idx]+maxProfit(idx+1, x-1, y, a, b);
        }
        else if (x!=0 && y==0) {
            return b[idx]+maxProfit(idx+1, x, y-1, a, b);
        }
        return Math.max(
            a[idx] + maxProfit(idx+1, x-1, y, a, b),
            b[idx] + maxProfit(idx+1, x, y-1, a, b)
        );
    }
    
    public static int maxProfit(int x, int y, int[] a, int[] b) {
        // code here
        int ans=0;
        //_Algorithm:
        //__1. Define Two PQ For A & B Respectively
        //__2. Then Compare Top Element From Each Of Them Add It In Result
               // Mark That Indices As Taken
        //__3. Top Largest Should Not Be Already Visited
        PriorityQueue<int[]> pqA=new PriorityQueue<>((m,n)->{
            if (m[0]!=n[0]) {
                return n[0]-m[0];
            }
            return m[1]-n[1];
        });
        PriorityQueue<int[]> pqB=new PriorityQueue<>((m,n)->{
            if (m[0]!=n[0]) {
                return n[0]-m[0];
            }
            return m[1]-n[1];
        });  
        //__Populate PQs
        for (int i=0;i<a.length;i++) {
            pqA.add(new int[]{a[i],i});
        }
        for (int i=0;i<b.length;i++) {
            pqB.add(new int[]{b[i],i});
        }
        //__Keep track of already visited indices
        Set<Integer> alreadyTaken=new HashSet<>();
        while (x != 0 || y != 0) {
            if (x==0 && y!=0) {
                while (!pqB.isEmpty() && alreadyTaken.contains(pqB.peek()[1])) {
                    pqB.poll();
                }
                ans += pqB.peek()[0];
                alreadyTaken.add(pqB.peek()[1]);
                pqB.poll();
                y=y-1;
            }
            else if (x!=0 && y==0) {
                while (!pqA.isEmpty() && alreadyTaken.contains(pqA.peek()[1])) {
                    pqA.poll();
                }

                ans += pqA.peek()[0];
                alreadyTaken.add(pqA.peek()[1]);
                pqA.poll();
                x=x-1;
            }
            else if (x==0 && y==0) {
                break;
            }
            else {
                //__Cleaning Remove All Already Taken Indices
                while (!pqA.isEmpty()) {
                    if (alreadyTaken.contains(pqA.peek()[1])) {
                        pqA.poll();
                    }
                    else {
                        break;
                    }
                }
                while (!pqB.isEmpty()) {
                    if (alreadyTaken.contains(pqB.peek()[1])) {
                        pqB.poll();
                    }
                    else {
                        break;
                    }
                }
                if (pqA.peek()[0]>pqB.peek()[0]) {
                    alreadyTaken.add(pqA.peek()[1]);
                    ans=ans+pqA.peek()[0];
                    pqA.poll();
                    x=x-1;
                }
                else {
                    alreadyTaken.add(pqB.peek()[1]);
                    ans=ans+pqB.peek()[0];
                    pqB.poll();
                    y=y-1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Input: x = 3, y = 3, a[] = [1, 2, 3, 4, 5], b[] = [5, 4, 3, 2, 1]
        int ans=maxProfit(0,3,3,new int[]{1,2,3,4,5},new int[]{5,4,3,2,1});
        System.out.println(ans);
    }
}
