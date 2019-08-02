package DSA.DP;

public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.printf("The length of the LPS is %d", lpsDP(seq.toCharArray()));
    }

    private static int lps(char[] charArray, int start, int end) {

        if(start==end)
            return 1;

        if(charArray[start]==charArray[end] && start+1==end){
            return 2;
        }
        if(charArray[start]==charArray[end]){
            return lps(charArray,start+1,end-1)+2;
        }

        if(charArray[start]!= charArray[end])
            return Math.max(lps(charArray,start+1,end), lps(charArray,start,end-1));

        return 0;
    }

    private static int lpsDP(char[] arr){
        int[][] dpArr = new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            dpArr[i][i]=1;
        }

        for(int len = 2; len<=arr.length;len++){
            for(int i=0;i<arr.length-len+1;i++){
                int j = i+len-1;
                if(arr[i]==arr[j] && len==2){
                    dpArr[i][j]=2;
                }
                if(arr[i]==arr[j])
                    dpArr[i][j]=2+ dpArr[i+1][j-1];
                if(arr[i]!=arr[j])
                    dpArr[i][j]=Math.max(dpArr[i+1][j], dpArr[i][j-1]);
            }
        }
        return dpArr[0][arr.length-1];
    }
}
