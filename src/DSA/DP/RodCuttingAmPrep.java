package DSA.DP;

public class RodCuttingAmPrep {
    public static void main(String[] args) {

        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(arr, arr.length));
        System.out.println(dpCutRod(arr, arr.length));

    }

    private static int dpCutRod(int[] arr, int n) {
        int[] dp = new int[n+1];

        dp[0]=0;
        for(int i=1;i<=n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                max = Math.max(max, arr[j]+dp[i-j-1]);
            }
            dp[i] = max;
        }

        return dp[n];
    }

    private static int cutRod(int[] arr, int n) {
        if (n <= 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i] + cutRod(arr, n - i - 1));
        }
        return max;
    }


}
