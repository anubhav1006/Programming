package DSA.DP;

public class WaysCoverDistance {
    public static void main(String[] args) {
        int dist = 4;
        System.out.println(printCountRec(dist));
        System.out.println(printCountDp(dist));
    }

    private static int printCountRec(int n) {
        if(n<0)
            return 0;
        if(n==0)
            return 1;

        return printCountRec(n-1)+printCountRec(n-2)+printCountRec(n-3);
    }

    private static int printCountDp(int n) {
        int[] dp = new int[n+1];

        dp[0]=1;
        dp[1] =1;
        for(int i=2;i<=n;i++){
            if(i>=3)
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            else {
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
}
