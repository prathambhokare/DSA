import java.util.*;

public class Solution12 {

    public static int totalPacketDropped(int[][] requests,int rate,int maxPackets) {
        int ans=0;
        int packetSent=requests[0][1];
        for (int i=1;i<requests.length;i++) {
            int totalPacketSentToClient=(requests[i][0]-requests[i-1][0])*rate;
            packetSent=packetSent-totalPacketSentToClient;
            packetSent=packetSent+requests[i][1];
            ans=ans+(packetSent%(maxPackets+1));
            packetSent=packetSent-(packetSent%(maxPackets+1));
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] requests = {
            {1,8},
            {4,9},
            {6,7}
        };
        int ans=totalPacketDropped(requests,2,10);
        System.out.println(ans);
    }
}
