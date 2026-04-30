import java.util.*;

public class Solution7 {
    public static void getSet(int i,int n,long target,Set<Integer> set) {
        if (target==0) {
            return;
        }
        if (i>n || target<0) {
            set.clear();
            return;
        }
        set.add(i);
        getSet(i+1,n,target-i,set);
        getSet(i+1,n,target,set);
        // set.remove(i);
        return;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long sum=0;
        for (int i=0;i<=n;i++) {
            sum=sum+(long)i;
        }
        if (sum%2!=0) return;
        long halfSum=sum/2;
        Set<Integer> set=new HashSet<>();
        getSet(1,n,halfSum,set);

        List<Integer> ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        for (int i=1;i<=n;i++) {
            if (set.contains(i)) {
                ans1.add(i);
            }
            else {
                ans2.add(i);
            }
        }
        System.out.println(ans1.size());
        for (int i=0;i<ans1.size();i++) {
            System.out.print(ans1.get(i) + " ");
        }
        System.out.println(ans2.size());
        for (int i=0;i<ans2.size();i++) {
            System.out.print(ans2.get(i) + " ");
        }
    }
}
