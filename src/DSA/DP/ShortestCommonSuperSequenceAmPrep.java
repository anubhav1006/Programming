package DSA.DP;

public class ShortestCommonSuperSequenceAmPrep {
    public static void main(String[] args) {
        String s1 = "algorithm";
        String s2 = "rhythm";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +dpPrintScs( X, Y, m, n ) );
    }

    private static String dpPrintScs(char[] x, char[] y, int m, int n) {
        int[][] val =  new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    val[i][j]=j;
                }else if(j==0){
                    val[i][j] = i;
                }
                else if(x[i-1]==y[j-1])
                    val[i][j]=1+val[i-1][j-1];
                else {
                    val[i][j] = 1+Math.min(val[i-1][j], val[i][j-1]);
                }
            }
        }
        //return val[m][n]+"";
        System.out.println(val[m][n]);

        String res = "";

        int i =m, j=n;

        while(i>0 && j>0){
            if(x[i-1]==y[j-1]){
                res = x[i-1]+res;
                i--;
                j--;
            }else if(val[i][j-1]>val[i-1][j]){
                res = x[i-1]+res;
                i--;
            }else{
                res = y[j-1]+res;
                j--;
            }
        }
        while(i>0){
            res = x[i-1]+res;
            i--;
        }
        while(j>0){
            res = y[j-1]+res;
            j--;
        }

        return res;
    }
}
