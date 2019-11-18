package DSA.DP.Try_1;

import java.util.Map;

//Shortest Common Supersequence
public class scs {
    public static void main(String[] args) {
        String a = "algorithm";
        String b = "rhythm";

        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        System.out.println(scs_print(arr1,arr2,arr1.length,arr2.length));
    }

    private static int scs_print(char[] arr1, char[] arr2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for (int j = 0; j <=n; j++) {
                if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j]= i;
                else if (arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = 1+Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        String res = "";
        int i = m,j=n;
        while(i>0&& j>0){
            if(arr1[i-1]==arr2[j-1]){
                res = arr1[i-1]+res;
                i--;
                j--;
            }else{
                if(dp[i-1][j]<dp[i][j-1]){
                    res = arr1[i-1]+res;
                    i--;
                }else {
                    res = arr2[j-1]+res;
                    j--;
                }
            }
        }
        while(i>0){
            res=arr1[i-1]+res;
            i--;
        }
        while(j>0){
            res = arr2[j-1]+res;
            j--;
        }

        System.out.println(res);


        return dp[m][n];
    }
}
