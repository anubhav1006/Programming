package DSA.DP;

public class MininumPartition {
    public static void main(String[] args) {
        int arr[] = {3, 1, 7, 3, 2, 1};
        int n = arr.length;
        System.out.println(findMin(arr, n));
    }

    private static int findMin(int[] arr, int n) {
        int sum =0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }

        //return findMinDifference(arr, n, 0,sum);
        return findMinDifferenceDp(arr, n, sum);
    }

    private static int findMinDifferenceDp(int[] arr, int n, int sum) {
        boolean[][] val = new boolean[sum+1][n+1];

        for(int i=0;i<=n;i++){
            val[0][i]=true;
        }
        for(int i=0;i<=sum;i++){
            val[i][0] = false;
        }

        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                val[i][j] = val[i][j-1];
                if(i>=arr[j-1])
                    val[i][j] = val[i][j]|| val[i-arr[j-1]][j-1];
            }

        }

        int min = Integer.MAX_VALUE;

        for(int i=sum;i>=sum/2;i--){
            if(val[i][n]){
                if(min>(sum-2*i)){
                    min = sum - 2*i;
                    break;
                }

            }
        }
        return min;
    }

    private static int findMinDifference(int[] arr, int n, int sum2, int sum) {
        if(n==0)
            return Math.abs((sum-sum2)-sum2);

        return Math.min(findMinDifference(arr, n-1, sum2+arr[n-1], sum), findMinDifference(arr, n-1, sum2, sum));
    }


}
