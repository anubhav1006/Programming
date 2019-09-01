package DSA.Stack;

import java.util.Scanner;
import java.util.Stack;

public class ParanthesisBalance {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        String temp ="";
        while(t>0){
            String s = in.nextLine();
            Stack<Character> st = new Stack<>();
            boolean flag = true;
            char[] arr = s.toCharArray();
            for(char c:arr){
                if(c=='('||c=='{'||c=='[')
                    st.push(c);
                else{
                    char e = getEnd(c);
                    if(st.isEmpty() || !(st.pop().equals(e))){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag && st.isEmpty())
                System.out.println("balanced");
            else{
                System.out.println("not balanced");
            }
            t--;

        }
    }

    private static char getEnd(char c) {
        switch (c){
            case ')': return '(';
            case '}': return '{';
            case ']':return '[';
            default:return 'N';
        }
    }
}
