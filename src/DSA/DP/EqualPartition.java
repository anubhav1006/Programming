package DSA.DP;

import java.util.Arrays;

public class EqualPartition {
    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 9, 12};
        int n = arr.length;
        if (findPartition(arr, n))
            System.out.println("Can be divided into two "+
                    "subsets of equal sum");
        else
            System.out.println("Can not be divided into " +
                    "two subsets of equal sum");
    }

    private static boolean findPartition(int[] arr, int n) {
        int sum = sum(arr,n);
        if(sum%2!=0)
            return false;
       return  _findPartitionDp(arr, n, sum);
    }

    private static boolean _findPartition(int[] arr, int n, int sum) {
        if(sum==0)
            return true;
        if(n==0 && sum!=0)
            return false;
        return _findPartition(arr,n-1,sum/2) || _findPartition(arr, n-1, sum/2-arr[n-1]);
    }

    private static boolean _findPartitionDp(int[] arr, int n, int sum) {
        boolean[][] val = new boolean[sum/2+1][n+1];

        for(int i=0;i<=n;i++){
            val[0][i]=true;
        }
        for(int i=0;i<=sum/2;i++){
            val[i][0]=false;
        }

        for(int i=1;i<=sum/2;i++){
            for(int j=1;j<=n;j++){
                val[i][j]=val[i][j-1];
                if(i>=arr[j-1])
                    val[i][j]=val[i][j-1]||val[i-arr[j-1]][j-1];
            }
        }
        return val[sum/2][n];
    }

    private static int sum(int[] arr, int n) {
        int sum =0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        return sum;
    }
}
