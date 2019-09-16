package DSA.DP;

public class LongestIncreasingSubsequenceAmPrep {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is "
                + lis(arr, n) + "\n");
    }
    static int max_res;
    private static int lis(int[] arr, int n) {
        max_res = 1;

        _lis(arr, n);
        return max_res;
    }

    private static int _lis(int[] arr, int n) {
        if(n==1)
            return 1;
        int max = 1;
        int res =1;
        for(int i=1;i<n;i++){
            res= _lis(arr,i);
            if(arr[i-1]<arr[n-1]&& res+1>max)
                max = res+1;
        }
        if(max_res<max)
            max_res = max;

        return max;
    }
}
