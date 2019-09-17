package DSA.DP;

public class IsSubsetSumAmPrep {
    public static void main(String[] args) {
        int set[] = {3, 34, 8, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSumDp(set, n, sum))
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    private static boolean isSubsetSum(int[] set, int n, int sum) {
        if(n==0&&sum!=0)
            return false;
        if(sum==0)
            return true;

        if(set[n-1]>sum)
            return isSubsetSum(set, n-1,sum);

        return isSubsetSum(set, n-1,sum) || isSubsetSum(set, n-1,sum-set[n-1]);
    }

    private static boolean isSubsetSumDp(int[] set, int n, int sum){
        boolean[][] val = new boolean[sum+1][n+1];
        for(int i=1;i<=n;i++){
            val[0][i] = true;
        }


        for(int i=1;i<=sum;i++){

            for(int j=1;j<=n;j++){
                val[i][j] = val[i][j-1];
                if(i>=set[j-1]){
                    val[i][j] = val[i][j] || val[i-set[j-1]][j-1];
                }
            }
        }

        return val[sum][n];

    }
}
