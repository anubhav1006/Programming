package DSA.DP;

public class LongestCommonSubSequenceAmPrep {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +dpPrintLcs( X, Y, m, n ) );
    }

    private static int lcs(char[] x, char[] y, int m, int n) {
        if(m==0|| n==0)
            return 0;

        if(x[m-1]==y[n-1]){
            return 1+lcs(x,y,m-1,n-1);
        }else{
            return Math.max(lcs(x,y,m-1,n), lcs(x,y,m,n-1));
        }
    }
    private static int dpLcs(char[] x, char[] y, int m, int n) {
        int[][] val = new int[m+1][n+1];

        for(int i=0;i<m;i++){
            val[i][0]=0;
        }
        for(int i=0;i<n;i++){
            val[0][i]=0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x[i-1]==y[j-1]){
                    val[i][j] = 1+val[i-1][j-1];
                }else{
                    val[i][j] = Math.max(val[i-1][j], val[i][j-1]);
                }
            }
        }
        return val[m][n];
    }

    private static String dpPrintLcs(char[] x, char[] y, int m, int n) {
        int[][] val = new int[m+1][n+1];

        for(int i=0;i<m;i++){
            val[i][0]=0;
        }
        for(int i=0;i<n;i++){
            val[0][i]=0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x[i-1]==y[j-1]){
                    val[i][j] = 1+val[i-1][j-1];
                }else{
                    val[i][j] = Math.max(val[i-1][j], val[i][j-1]);
                }
            }
        }


        String res = "";
        int i=m, j=n;
        while(i>0 && j>0){
            if(x[i-1]==y[j-1]) {
                res = x[i - 1]+res;
                i--;j--;
            }
            else if(val[i][j-1]>val[i-1][j]){
                //res=x[i-1]+res;
                j--;
            }else {
                //res=y[j-1]+res;
                i--;
            }
        }
        /**/
        return res;
    }
}
