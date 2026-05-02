package LEETCODEPOTD;

public class Solution2 {
        public boolean chekIfContainsInValidNumbers(int n) {
        boolean isChanged=false;
        while (n>0) {
            if (n%10==3 || n%10==4 || n%10==7) {
                return false;
            }
            if (n%10==2 || n%10==5 || n%10==6 || n%10==9) {
                isChanged=true;
            }
            n=n/10;
        }
        return isChanged;
    }

    int count=0;

    public void generateValidNumbers(int i,int[] nums,int n,String num) {
        if (i>=nums.length) {
            // System.out.println(num);
            if (num!="" && Integer.parseInt(num)<=n) {
                System.out.println(Integer.parseInt(num));
                count=count+1;
            }
            return;
        }

        generateValidNumbers(i+1,nums,n,num+nums[i]);
        generateValidNumbers(i+1,nums,n,num);
        return;
    }
    
    public int rotatedDigits(int n) {
        //Brute Force Approach
        //_3,4,7
        int ans=0;
        for (int i=1;i<=n;i++) {
            if (chekIfContainsInValidNumbers(i)) {
                ans=ans+1;
            }
        }
        return ans;
        // int[] nums=new int[]{0,1,2,5,6,8,9};
        // generateValidNumbers(0,nums,n,"");
        // int ans=count;
        // count=0;
        // nums=new int[]{0,1,8};
        // generateValidNumbers(0,nums,n,"");
        // int ans1=count;
        // System.out.println(ans + " " + ans1);
        // return ans-ans1;
    }
}
