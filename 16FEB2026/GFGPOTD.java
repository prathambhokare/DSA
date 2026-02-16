class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        int[][] timeline=new int[arr.length*2][2];
        int k=0;
        for (int i=0;i<arr.length;i++) {
            timeline[k][0]=arr[i][0];
            timeline[k][1]=1;
            timeline[k+1][0]=arr[i][1]-1;
            timeline[k+1][1]=-1;
            k=k+2;
        }
        Arrays.sort(timeline,(a,b)->{
            return a[0]-b[0];
        });
        int cnt=0;
        for (int i=0;i<timeline.length;i++) {
            cnt=cnt+timeline[i][1];
            // System.out.println(timeline[i][1]);
            if (cnt>1) {
                return false;
            }
        }
        return true;
    }
}