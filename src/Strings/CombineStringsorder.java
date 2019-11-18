package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombineStringsorder {
    public static void main(String[] args) {
        String a = "AB";
        String b = "CD";

        int n1 = a.length();
        int n2 = b.length();

        List<String> res = new ArrayList<>();
        Set<String> res1 = new HashSet<>();
        for (int i=1;i<=n2;i++){
            String t1 = a.substring(0,i);
            String t2 = a.substring(i);
            for (int j=0;j<n1;j++){
                res1.add(b.substring(0,j)+t1+b.substring(j)+t2);
            }
        }
        /*for (int i=1;i<=n1;i++){
            String t1 = b.substring(0,i);
            String t2 = b.substring(i);
            for (int j=0;j<n2;j++){
                res1.add(a.substring(0,j)+t1+a.substring(j)+t2);
            }
        }*/

        for (String result:res1){
            System.out.println(result);
        }
        System.out.println(res1.size());
    }
}
