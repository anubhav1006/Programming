package DSA.DP;

public class CoinChangeAmPrep {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int n = 4;

        System.out.println(dpCountWays(arr,arr.length, n));
    }

    private static int countWays(int[] arr, int m, int n) {
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(m<=0 && n>=1)
            return 0;

        return countWays(arr, m-1, n)+countWays(arr, m,n-arr[m-1]);
    }

    private static int dpCountWays(int[] arr, int m, int n){
        int[] val = new int[n+1];

        val[0] = 1;

        for(int i=0;i<m;i++){
            for(int j=arr[i];j<=n;j++){
                val[j] = val[j]+val[j-arr[i]];
            }
        }
        return val[n];
    }
}
