package Strings;

import java.util.*;


public class AddNumbers {
    public static void main(String[] args) {
        int[] arr = {2,7, 31, 9, 83, 56, 8, 80};
        List<Integer> arrList = new ArrayList<>();

        for(int i:arr){
            arrList.add(i);
        }



        class compareNumbers implements Comparator<Integer>{
            @Override
            public int compare(Integer o1, Integer o2) {
                StringBuilder sb =new StringBuilder(o1+"");
                StringBuilder sb2 = new StringBuilder(o2+"");

                String s1 = sb.append(sb2).toString();
                String s2 = sb2.append(sb).toString();

                return s1.compareTo(s2)*-1;
            }
        }

        Collections.sort(arrList, new compareNumbers());
        String res="";
        for(Integer i: arrList){
            res+=i;
        }
        System.out.println(res);
    }
}
