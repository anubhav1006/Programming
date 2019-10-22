package DSA.Arrays;

import java.util.*;

public class FirstLeader {
    public static void main(String[] args) {
        int[] arr = {4,2,5,7};

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        left[0]=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>left[i-1])
                left[i]=arr[i];
            else
                left[i] = left[i-1];
        }
        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]<right[i+1])
                right[i] = arr[i];
            else
                right[i]=right[i+1];
        }

        for(int i=0;i<n;i++){
            if(left[i]==right[i]) {
                //System.out.println(left[i]);
                break;
            }

        }
        HashSet dset = new HashSet();
        dset.add(2);
        dset.add(1);
        dset.add((int)'A');
        dset.add(5);
        dset.add(444);

        Iterator iterator = dset.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        LinkedHashSet<Integer> dset1 = new LinkedHashSet();
        dset1.add(2);
        dset1.add(1);
        dset1.add((int)'A');
        dset1.add(5);
        dset1.add(444);
        Iterator iterator1 = dset1.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();
        String abc = "dfgdfg";

        abc.contains("df");


        TreeSet dset11 = new TreeSet();
        dset11.add(2);
        dset11.add(1);
        dset11.add((int)'A');
        dset11.add(5);
        dset11.add(444);
        Iterator iterator11 = dset11.iterator();
        while (iterator11.hasNext()) {
            System.out.print(iterator11.next() + " ");
        }
    }
}
