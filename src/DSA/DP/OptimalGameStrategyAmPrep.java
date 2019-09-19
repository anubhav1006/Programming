package DSA.DP;

import java.util.Arrays;

public class OptimalGameStrategyAmPrep {
    public static void main(String[] args) {
        int []arr1 = { 8, 15, 3, 7 };
        int n = arr1.length;
        System.out.println(optimalStrategyOfGame(arr1, n));

        int []arr2 = { 2, 2, 2, 2 };
        n = arr2.length;
        System.out.println(optimalStrategyOfGame(arr2, n));

        int []arr3 = { 20, 30, 2, 2, 2, 10 };
        n = arr3.length ;
        System.out.println(optimalStrategyOfGame(arr3, n));
    }

    static int[][] dp;
    private static int optimalStrategyOfGame(int[] arr, int n) {
        int sum =0;
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            sum += arr[i];
            Arrays.fill(dp[i],-1);
        }



        return maxResultDp(arr, 0, n-1, sum);
    }

    private static int maxResult(int[] arr, int i, int j, int sum) {
        if(i+1==j)
            return Math.max(arr[i], arr[j]);

        return sum - Math.max(maxResult(arr, i+1, j, sum-arr[i]), maxResult(arr, i, j-1, sum-arr[j]));
    }

    private static int maxResultDp(int[] arr, int i, int j, int sum) {
        if(i+1==j)
            return Math.max(arr[i],arr[j]);
        if(dp[i][j]!=-1)
            return dp[i][j];

        return sum - Math.max(maxResult(arr, i+1, j, sum-arr[i]), maxResult(arr, i, j-1, sum-arr[j]));
    }
}
