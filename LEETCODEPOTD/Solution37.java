package LEETCODEPOTD;

public class Solution37 {

    public static double angleClock(int hour, int minutes) {
        double ans=0.0;
        if (hour==12) {
            hour=0;
        }
        double extraminutes=((double)minutes/12)*(double)6;
        System.out.println(extraminutes);
        ans=Math.abs(hour*30+extraminutes-minutes*6);
        return Math.min(ans,360-ans);
    }

    public static void main(String[] args) {
        double ans=angleClock(3, 15);
        System.out.println(ans);
    }
}
