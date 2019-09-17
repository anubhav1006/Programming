package DSA.DP;

public class LongestPathMatrixAmPrep {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}};
        System.out.println("Length of the longest path is " + finLongestOverAll(mat));
    }

    private static int finLongestOverAll(int[][] mat) {
        int m = mat[0].length;
        int n = mat.length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1)
                    longestPath(mat, i, j, dp);

                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    private static int longestPath(int[][] mat, int i, int j, int[][] dp) {

        int m = mat[0].length;
        int n = mat.length;
        if (i < 0 || j < 0 || i >= m || j >= n)
                return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int w, x, y, z;
        w = x =  y =  z = Integer.MIN_VALUE;

        if (i < m - 1 && mat[i + 1][j] == mat[i][j] + 1)
            w = dp[i][j] = 1 + longestPath(mat, i + 1, j, dp);

        if (j < n - 1 && mat[i][j + 1] == mat[i][j] + 1)
            x = dp[i][j] = 1 + longestPath(mat, i, j + 1, dp);

        if (i > 0 && mat[i - 1][j] == mat[i][j] + 1)
            y = dp[i][j] = 1 + longestPath(mat, i - 1, j, dp);

        if (j > 0 && mat[i][j - 1] == mat[i][j] + 1)
            z = dp[i][j] = 1 + longestPath(mat, i, j - 1, dp);


        return dp[i][j] = Math.max(w, Math.max(x, Math.max(y, Math.max(z,1))));

    }
}
