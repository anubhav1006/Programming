package DSA.DP.Try_1;

import java.util.Arrays;

public class lis {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };

        System.out.println(lisof(arr));
    }

    private static int lisof(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        dp[0] = 1;


        for(int i=1;i<n;i++){
            int max =dp[i];
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && max<dp[j]+1){
                    max = dp[j]+1;
                }
            }
            dp[i] = max;
        }
        int m = 0;
        for (int i = 0; i < n; i++) {
            if(m<dp[i])
                m=dp[i];
        }
        return m;
    }
}
