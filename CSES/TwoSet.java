import java.util.*;

public class TwoSet {
	public static void twoSets(int n) {
		List<Integer> set1=new ArrayList<>();
		List<Integer> set2=new ArrayList<>();
		long sum=0;
		for (int i=1;i<=n;i++) {
			sum=sum+(long)i;
		}
		if (sum%2!=0) {
			System.out.println("Not Possible");
			return;
		}
		long target=sum/2;
		for (int i=1;i<=n;i++) {
			if (i<=target) {
				target=target-i;
				set1.add(i);
			}
			else {
				set2.add(i);
			}
		}
		for (int i=0;i<set1.size();i++) {
			System.out.print(set1.get(i) + " ");
		}
		System.out.println();
		for (int i=0;i<set2.size();i++) {
			System.out.print(set2.get(i) + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// write your code here
		int n=7;
		twoSets(n);
	}
}