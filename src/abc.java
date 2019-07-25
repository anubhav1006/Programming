import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class abc {


    public static class Solution {

        // Complete the candies function below.
        static long candies(int n, int[] arr) {
            long[] arrVal = new long[n];
            Arrays.fill(arrVal, 1);
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    arrVal[i]++;
                }
            }
            Math.max(1, 2);
            for (int j = arr.length - 1; j > 0; j--) {
                if (arr[j] > arr[j - 1])
                    arrVal[j]++;
            }
            Math.abs(-3 - 5);
            long sum = 0;
            for (int i = 0; i < arrVal.length; i++) {
                sum += arrVal[i];
            }

            return sum;

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                int arrItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                arr[i] = arrItem;
            }

            long result = candies(n, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();
            /*Stack<Integer> stack;*/
            scanner.close();
        }
    }




}

