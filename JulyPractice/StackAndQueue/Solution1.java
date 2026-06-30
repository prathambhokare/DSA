package JulyPractice.StackAndQueue;

import java.util.*;;

public class Solution1 {
    
    //Prefix,Infix And Postfix Conversion
    //Operand -> a-z,A-Z or 0-9
    //Operator -> 
    // -> ^    3 (highest)
    // -> * /  2 
    // -> + -  1 (lowest)

    public int getOperatorPriority(char ch) {
        if (ch=='^') {
            return 3;
        }
        else if (ch=='*' || ch=='/') {
            return 2;
        }
        else if (ch=='+' || ch=='-') {
            return 1;
        }
        return 0;
    }

    public String infixToPostfix(String str) {
        String ans="";
        Stack<Character> st=new Stack<>();
        for (int i=0;i<str.length();i++) {
            char ch=str.charAt(i);
            if (ch<='a' && ch<='z' || ch<='A' && ch<='Z' || ch<='0' && ch<='9') {
                ans=ans+ch;
            }
            else {
                if (st.isEmpty()) {
                    st.push(ch);
                }
                else if (ch==')') {
                    while (!st.isEmpty() && st.peek()!='(') {
                        ans=ans+st.peek();
                        st.pop();
                    }
                    if (!st.isEmpty()) {
                        st.pop();
                    }
                }
                else {
                    while (getOperatorPriority(st.peek())>getOperatorPriority(ch)) {
                        ans=ans+st.peek();
                        st.pop();
                    }
                    st.push(ch);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}
