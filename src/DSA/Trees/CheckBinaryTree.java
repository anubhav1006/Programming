package DSA.Trees;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckBinaryTree {

    /*
    Input
6
l
lr
r
-
llrr
rl
    * */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Set<String> stringSet = new HashSet<>();
        while(n>0){
            stringSet.add(in.nextLine());
            n--;
        }

        if(checkTree(stringSet))
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static boolean checkTree(Set<String> stringSet) {
        for(String s:stringSet){
            if(s.length()==1){
                if(!stringSet.contains("-")) {
                    System.out.println(s);
                    return false;
                }
            }else{
                if(!stringSet.contains(s.substring(0,s.length()-1))){
                    System.out.println(s);
                    return false;
                }
            }
        }
        return true;
    }
}
