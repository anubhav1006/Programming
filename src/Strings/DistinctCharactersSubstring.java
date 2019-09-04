package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctCharactersSubstring {
    public static void main(String[] args) {
        //String str = "geeksforgeeks";
        //String str ="aldshflasghdfasgfkhgasdfasdgvfyweofyewyrtyefgv";
        String str = "qwertyuioplkjh";

        System.out.println("Largest distince substring is: "+distinctSubstring(str));
    }

    private static String distinctSubstring(String str) {
        char[] charArr = str.toCharArray();
        Map<Character, Integer> charSet = new HashMap<>();
        int start=0, end =1;
        int maxStart =0, maxEnd =1;
        for(int j=0;j<charArr.length;j++){
            char i = charArr[j];
            if(!charSet.containsKey(i) || (j-charSet.get(i)>end-start-1)){
                charSet.put(i,j);
            }else{
                int loc = charSet.get(i);
//                charSet.remove(i);
                charSet.put(i,j);
                if(maxEnd - maxStart<end-start) {
                    maxEnd = end-1;
                    maxStart = start;
                }
                start=loc+1;
            }
            end++;
        }
        if(maxEnd - maxStart<end-start) {
            maxEnd = end-1;
            maxStart = start;
        }

        return str.substring(maxStart, maxEnd);
    }
}
