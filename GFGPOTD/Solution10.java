import java.util.*;

public class Solution10 {


    public static Set<String> ans=new HashSet<>();

    public static int maxLength=0;

    public static void generateAllSubstrings(int idx,
                                      String s,
                                      String ansval,
                                      int open,
                                      int close) {

        // invalid state
        if (close>open) {
            return;
        }

        // pruning
        if (ansval.length()+(s.length()-idx)<maxLength) {
            return;
        }

        if (idx==s.length()) {

            if (open==close) {

                if (ansval.length()>maxLength) {

                    maxLength=ansval.length();
                    ans.clear();
                    ans.add(ansval);
                }
                else if (ansval.length()==maxLength) {
                    ans.add(ansval);
                }
            }

            return;
        }

        char ch=s.charAt(idx);

        //take
        if (ch=='(') {

            generateAllSubstrings(idx+1,
                                  s,
                                  ansval+ch,
                                  open+1,
                                  close);
        }
        else if (ch==')') {

            generateAllSubstrings(idx+1,
                                  s,
                                  ansval+ch,
                                  open,
                                  close+1);
        }
        else {

            generateAllSubstrings(idx+1,
                                  s,
                                  ansval+ch,
                                  open,
                                  close);
        }

        //non-take
        generateAllSubstrings(idx+1,
                              s,
                              ansval,
                              open,
                              close);
    }

    public static List<String> validParenthesis(String s) {

        generateAllSubstrings(0,s,"",0,0);

        List<String> res=new ArrayList<>(ans);

        Collections.sort(res);

        return res;
    }

    public static void main(String[] args) {
      List<String> ans=validParenthesis("(())()()");
      for (int i=0;i<ans.size();i++) {
        System.out.print(ans.get(i) + " ");
      }
      System.out.println();
    }
}
