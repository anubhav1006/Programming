package DSA.DP;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int n = 4;

        System.out.println(countWays(arr, n));
    }

    private static int countWays(int[] arr, int n){
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=0;i<arr.length;i++){

            for(int j= arr[i];j<=n;j++){
                dp[j] += dp[j-arr[i]];
            }
        }
        return dp[n];
    }
}
