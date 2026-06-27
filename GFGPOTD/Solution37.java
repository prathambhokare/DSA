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
[22:56, 17/6/2026] Pratham: Name: Pratham Subhash Bhokare
Email: prathambhokare2017@gmail.com
Mob No: +91 7841885229
Location: Pune

https://www.linkedin.com/me?trk=p_mwlite_feed-secondary_nav
[22:57, 17/6/2026] Pratham: https://www.linkedin.com/in/pratham-bhokare-aab066199?trk=contact-info