public class Solution37 {

    public static int maxPeopleDefeated(int p) {
        // code here
        int ans=0;
        int i=1;
        while (i*i<=p) {
            p=p-i*i;
            ans=ans+1;
            i=i+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=maxPeopleDefeated(14);
        System.out.println(ans);
    }
}
