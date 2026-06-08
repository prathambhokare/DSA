public class Solution31 {
    public static boolean canSeatAllPeople(int k, int[] seats) {
        // code here
        int[] ans=new int[seats.length];
        for (int i=0;i<seats.length;i++) {
            if (seats[i]==1) {
                if ((i-1)>=0) {
                    ans[i-1]=1;
                }
                if ((i+1)<seats.length) {
                    ans[i+1]=1;
                }
                ans[i]=1;
            }
        }
        int cntZero=0;
        for (int i=0;i<ans.length;i++) {
            if (ans[i]==1) {
                cntZero=cntZero/2+cntZero%2;
                k=k-cntZero;
                cntZero=0;
            }
            else {
                cntZero++;
            }
        }
        if (cntZero!=0) {
            cntZero=cntZero/2+cntZero%2;
            k=k-cntZero;
            cntZero=0;
        }
        if (k<=0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean ans=canSeatAllPeople(2,new int[]{0,0,1,0,0,0,1});
        System.out.println(ans);
    }
}
