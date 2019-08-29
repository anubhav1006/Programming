package DSA.DP;

public class EggDrop {
    public static void main(String[] args) {
        int n=2, k=10;

        System.out.println(calcRecAttempts(n,k));
    }

    private static int calculateNoOfAttempts(int n, int k) {
        int[][] arr = new int[n+1][k+1];

        for(int i=0;i<k;i++){
            arr[1][i] = i;
        }
        for(int i=0;i<n;i++){
            arr[i][0] = 0;
            arr[i][1] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=2;j<=k;j++){
                arr[i][j] = Integer.MAX_VALUE;
                for(int x =1;x<j;x++){
                    int res = 1+ Math.max(arr[i-1][x-1], arr[i][j-x]);
                    if(arr[i][j]>res)
                        arr[i][j] = res;
                }
            }
        }

        return arr[n][k];
    }

    private static int calcRecAttempts(int n, int k){
        if(k==0 || k==1){
            return k;
        }
        if(n==1)
            return k;

        int res, min=Integer.MAX_VALUE;

        for(int i=1;i<=k;i++){

            res = Math.max(calcRecAttempts(n-1,i-1), calcRecAttempts(n, k-i));
            if(res<min)
                min = res;

        }
        return 1+min;
    }
}
