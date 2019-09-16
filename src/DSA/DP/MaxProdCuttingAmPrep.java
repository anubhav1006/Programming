package DSA.DP;

public class MaxProdCuttingAmPrep {
    public static void main(String[] args)
    {
        System.out.println("Maximum Product is "
                + dpMaxProd(25));
    }

    private static int maxProd(int n){

        if(n==0 || n==1)
            return 0;
        int max = Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            max = Math.max(max, Math.max(i*(n-i), i*maxProd(n-i)));
        }

        return max;
    }

    private static int dpMaxProd(int n){
        int[] val = new int[n+1];

        val[0]=0;
        val[1]=0;
        for(int i=2;i<=n;i++){
            int max =Integer.MIN_VALUE;
            for (int j=1;j<=i/2;j++){
                max = Math.max(max, Math.max(j*(i-j), j*val[i-j]));
            }
            val[i]=max;
        }

        return val[n];
    }
}
