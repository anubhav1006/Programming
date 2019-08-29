package DSA.DP;

public class RodCutting {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(arr, arr.length));
        System.out.println(dpFinal(arr, arr.length));
    }

    private static int optimalSolution(int[] arr, int size) {
        int[] dp = new int[size+1];
//        for(int i=0;i<size;i++)
//        }

        for (int i = 1; i <=size; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, arr[j] + dp[i-j-1]);
                dp[i] = max;
            }
        }
        return dp[size];
    }

    private static int cutRod(int[] price, int n) {
        if (n <= 0)
            return 0;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, price[i] + cutRod(price, n - i - 1));
        }
        return maxVal;
    }

    private static int dpFinal(int[] price, int n){
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1;i<=n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                max = Math.max(max, price[j]+dp[i-(j+1)]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

}
