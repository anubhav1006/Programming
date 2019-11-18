package DSA.DP;

public class EggDropDP_Try1 {
    public static void main(String[] args) {
        int n=2, k=10;

        System.out.println(calcRecAttempts(n,k));
    }

    private static int calcRecAttempts(int n, int k) {
        int[][] eggfloor = new int[n+1][k+1];

        for(int i=0;i<k;i++){
            eggfloor[1][i] = i;
        }
        for (int i = 0; i < n; i++) {
            eggfloor[i][0] = 0;
            eggfloor[i][1] = 1;
        }

        for(int i=2;i<=n;i++){
            for (int j = 2; j <=k; j++) {
                    eggfloor[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <=j; x++) {

                    eggfloor[i][j] = Math.min(eggfloor[i][j],1 + Math.max(eggfloor[i][j-x],eggfloor[i-1][x-1]));
                }
            }
        }
        return eggfloor[n][k];
    }
}
