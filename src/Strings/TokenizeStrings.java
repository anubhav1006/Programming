package Strings;

public class TokenizeStrings {

    public static void main(String[] args) {
        String input = "This is my \"Special String : ABCD\" Alpha \"abcd ghi\" xyz";
        tokenizer(input);
        /*int start=0;
        int end=0;
        boolean stringOpen = false;
        for(int i=1;i<input.length();i++){
            if(i==input.length()-1)
                System.out.println(input.substring(start));
            if(stringOpen) {
                if (input.charAt(i) == '\"') {
                    System.out.println(input.substring(start, i));
                    stringOpen = false;
                    start = i+2;
                    i++;

                }
            }else{
                if (input.charAt(i) == ' ') {
                    System.out.println(input.substring(start, i));
                    start = i+1;
                }
                if (input.charAt(i) == '\"') {
                    stringOpen = true;
                    start = i + 1;
                }

            }
        }*/
    }

    public static void tokenizer(String str){
        Boolean qouteActive = false;
        String subS = "";
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) == '"'){
                qouteActive = !qouteActive;
            }
            if(str.charAt(i) == ' ' && !qouteActive){
                System.out.println(subS);
                subS = "";
            } else{
                subS = subS +str.charAt(i);
            }
        }
        System.out.println(subS);
    }
}
