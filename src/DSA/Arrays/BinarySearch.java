package DSA.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7};

        System.out.println(binarySearch(0, arr.length-1, arr, 3));

    }

    static int binarySearch(int start, int end, int[] arr, int x) {
        if(start<=end) {
            int mid = (end + start) / 2;

            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
               return binarySearch(start, mid-1, arr, x);
            }

            return binarySearch(mid + 1, end, arr, x);
        }
            return -1;

    }
}
