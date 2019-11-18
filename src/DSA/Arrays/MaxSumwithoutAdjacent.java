package DSA.Arrays;

public class MaxSumwithoutAdjacent {
    public static void main(String[] args) {
        int[] arr = {4,6,2,1,48,90};

        System.out.println(sum(arr));
    }

    private static int sum(int[] arr) {
        int inc= arr[0];
        int exc = 0;
        int new_ex;
        for (int i = 0; i < arr.length; i++) {
            new_ex = Math.max(inc,exc);
            inc = exc+arr[i];
            exc = new_ex;
        }

        return Math.max(inc,exc);
    }
}
