package LEETCODEPOTD;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution44 {
    
    public boolean mindistance(int distance,int[][] arr) {
        if (arr[0][0] < distance) {
            return false;
        }
        Queue<Integer[]> queue=new LinkedList<>();
        boolean[][] visited=new boolean[arr.length][arr[0].length];
        queue.add(new Integer[]{0,0});
        visited[0][0]=true;
        while(!queue.isEmpty()){
            Integer[] node=queue.poll();
            int x=node[0];
            int y=node[1];
            if(x==arr.length-1 && y==arr[0].length-1){
                return true;
            }
            if(x-1>=0 && !visited[x-1][y] && arr[x-1][y]>=distance){
                visited[x-1][y]=true;
                queue.add(new Integer[]{x-1,y});
            }
            if(y+1<arr[0].length && !visited[x][y+1] && arr[x][y+1]>=distance){
                visited[x][y+1]=true;
                queue.add(new Integer[]{x,y+1});
            }
            if(x+1<arr.length && !visited[x+1][y] && arr[x+1][y]>=distance){
                visited[x+1][y]=true;
                queue.add(new Integer[]{x+1,y});
            }
            if(y-1>=0 && !visited[x][y-1] && arr[x][y-1]>=distance){
                visited[x][y-1]=true;
                queue.add(new Integer[]{x,y-1});
            }
        }
        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<Integer[]> queue=new LinkedList<>();
        int[][] arr=new int[grid.size()][grid.get(0).size()];
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){

                if(grid.get(i).get(j)==1){
                    arr[i][j]=0;
                    queue.add(new Integer[]{i,j});
                }
                else{
                    arr[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()){
            Integer[] node=queue.poll();
            int x=node[0];
            int y=node[1];
            if(x-1>=0 && arr[x-1][y]>arr[x][y]+1){
                arr[x-1][y]=arr[x][y]+1;
                queue.add(new Integer[]{x-1,y});
            }
            if(y+1<arr[0].length && arr[x][y+1]>arr[x][y]+1){
                arr[x][y+1]=arr[x][y]+1;
                queue.add(new Integer[]{x,y+1});
            }
            if(x+1<arr.length && arr[x+1][y]>arr[x][y]+1){
                arr[x+1][y]=arr[x][y]+1;
                queue.add(new Integer[]{x+1,y});
            }
            if(y-1>=0 && arr[x][y-1]>arr[x][y]+1){
                arr[x][y-1]=arr[x][y]+1;
                queue.add(new Integer[]{x,y-1});
            }
        }
        int i=0;
        int j=arr.length+arr[0].length;
        int ans=0;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(mindistance(mid,arr)){
                ans=mid;
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return ans;
    }
}
