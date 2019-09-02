package DSA.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ChoclateDistributionProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while(t>0){
            int n = Integer.parseInt(in.nextLine());
            int[] arr = new int[n];
            String inputArray =  in.nextLine();
            int j=0;
            for (String i:inputArray.split(" ")){
                arr[j] = Integer.parseInt(i);
                j++;
            }
            int m = Integer.parseInt(in.nextLine());
            System.out.println(minDifference(arr,n,m));
            t--;
            Integer.parseInt();
        }
    }


    private static int minDifference(int[] arr, int n, int m) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=m-1,j=0;i<n;i++,j++){
            if(min>arr[i]-arr[j])
                min = arr[i]-arr[j];
        }

        return min;

    }


}
