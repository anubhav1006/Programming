package Strings;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "geeksforgeeks";

        print(input);
    }

    private static void print(String str) {
        int n = str.length();
        for(int i=0;i<n;i++){
            char c= str.charAt(i);
            int a = (str.substring(i+1)).indexOf(c);
            if( a >=0){
                str = str.substring(0,a+i+1)+str.substring(a+i+2);
                n--;
                i--;
            }
        }

        String a ="v";
        String b = a.substring(0,0);

       // System.out.println(str);
    }
}
