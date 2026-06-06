public class Solution29 {
    
    public static String profession(int level, int pos) {
        int flips = 0;

        while (level > 1) {
            if (pos % 2 == 0) {
                flips++;
            }
            pos = (pos + 1) / 2;
            level--;
        }

        return (flips % 2 == 0) ? "Engineer" : "Doctor";
    }

    public static void main(String[] args) {
        String ans=profession(4,2);
        System.out.println(ans);
    }
}
