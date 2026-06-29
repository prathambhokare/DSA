package JulyPractice.BinarySearch;

public class BinarySearchOnAnswer {
	public static int sqrt(int num) {
		int ans=0;
		int low=1;
		int high=num;
		while (low<=high) {
			int mid=(low+high)/2;
			if (mid*mid<=num) {
				ans=mid;
				low=mid+1;
			}
			else {
				high=mid-1;
			}
		}
		return ans;
	}
	public boolean isPossibleToEat(int k,int[] piles,int h) {
        int totalhours=0;
        int i=0;
        while (i<piles.length) {
            totalhours=totalhours+(int)Math.ceil((double)piles[i]/k);
            if (totalhours>h) {
                return false;
            }
            i=i+1;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int ans=0;
        int low=0;
        int high=0;
        for (int i=0;i<piles.length;i++) {
            high=Math.max(high,piles[i]);
        }
        while (low<=high) {
            int mid=(low+high)/2;
            if (isPossibleToEat(mid,piles,h)) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
	}
	public boolean isPossible(int days,int[] bloomDay,int m,int k) {
        int ans=0;
        int ansval=0;
        for (int i=0;i<bloomDay.length;i++) {
            if (bloomDay[i]<=days) {
                ansval=ansval+1;
            }
            else {
                ansval=0;
            }
            if (ansval==k) {
                m=m-1;
                ansval=0;
                if (m==0) {
                    return true;
                }
            }
        }
        if (m!=0) {
            return false;
        }
        return true;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int ans=0;
        if (bloomDay.length/k<m) {
            return -1;
        }
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for (int i=0;i<bloomDay.length;i++) {
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);
        }
        // System.out.println(high);
        while (low<=high) {
            int mid=low+(high-low)/2;
            System.out.println(mid);
            if (isPossible(mid,bloomDay,m,k)) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
	}
	public boolean isPossible(int divisior,int[] nums,int threshold) {
        long sum=0;
        for (int i=0;i<nums.length;i++) {
            sum=sum+(long)Math.ceil((double)nums[i]/divisior);
            if (sum>threshold) {
                return false;
            }
        }
        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int ans=0;
        int low=1;
        int high=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            low=Math.min(low,nums[i]);
            high=Math.max(high,nums[i]);
        }
        while (low<=high) {
            int mid=low+(high-low)/2;
            if (isPossible(mid,nums,threshold)) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
	}
	public boolean isPossible(int weight,int[] weights,int days) {
        int ans=0;
        int currweight=0;
        for (int i=0;i<weights.length;i++) {
            if ((currweight+weights[i])<=weight) {
                currweight=currweight+weights[i];
            }
            else {
                if (weights[i]>weight) {
                    return false;
                }
                currweight=weights[i];
                ans=ans+1;
            }
        }
        if (currweight<=weight) {
            ans=ans+1;
        }
        if (ans>days) {
            return false;
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int ans=0;
        int maxWeight=0;
        // Arrays.sort(weights);
        for (int i=0;i<weights.length;i++) {
            maxWeight=maxWeight+weights[i];
        }
        int s=1;
        int e=maxWeight;
        while (s<e) {
            int mid=(e+s)/2;
            if (isPossible(mid,weights,days)) {
                ans=mid;
                e=mid;
            }
            else {
                s=mid+1;
            }
        }
        return (s+e)/2;
	}
	public int findKthPositive(int[] arr, int k) {
        // 11-4=7-k=2
        // 11-2=9

        // 3-2-1=
        // 4-3-1<k 
        // >=k then optimize
        int ans=-1;
        int low=0;
        int high=arr.length-1;
        while (low<=high) {
            int mid=(low+high)/2;
            int ansval=arr[mid]-(mid+1);
            // System.out.println(ansval);
            if (ansval<k) {
                low=mid+1;
            }
            else {
                ans=arr[mid];
                high=mid-1;
            }
        }
        if (ans==-1) {
            return arr[arr.length-1]+(k-(arr[arr.length-1]-arr.length));
        }
        return low+k;
    }
	public static void main(String[] args) {
		// write your code here
		int ans=sqrt(36);
		System.out.println(ans);
    }
}
