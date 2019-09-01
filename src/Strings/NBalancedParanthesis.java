package Strings;

public class NBalancedParanthesis {
    public static void main(String[] args) {
        int n=5;

        print(n);
    }

    private static void print(int n) {
        int openParanthesis =0;
        int closedParanthesis=0;
        String s ="";
        printUtil(openParanthesis, closedParanthesis, s, n);
    }

    private static void printUtil(int openParanthesis, int closedParanthesis, String s, int n) {
        if(openParanthesis+closedParanthesis==2*n)
            System.out.println(s);
        if(openParanthesis==closedParanthesis && openParanthesis+closedParanthesis<2*n){
            printUtil(openParanthesis+1, closedParanthesis, s+"(",n);
        }else if(openParanthesis>closedParanthesis && openParanthesis<n){
            printUtil(openParanthesis+1, closedParanthesis,s+"(",n);
            printUtil(openParanthesis, closedParanthesis+1, s+")", n);
        }else if(openParanthesis>closedParanthesis && openParanthesis==n){
            printUtil(openParanthesis, closedParanthesis+1, s+")", n);
        }
    }
}
