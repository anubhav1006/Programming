package DSA.Arrays;

public class SpiralTraverse2dArray {
    public static void main(String[] args) {
        int m=3, n=3;
        int[][] arr = new int[m][n];

        int a=0;
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = ++a;
            }
        }

        int k=0,l=0;
        while(k<m && l<n){
            for(int i=l;i<n;i++){
                System.out.print(arr[k][i]+" ");
            }
            k++;

            for(int i=k;i<m;i++){
                System.out.print(arr[i][n-1]+" ");
            }
            n--;

            if(k<m){
                for(int i=n-1;i>=l;i--){
                    System.out.print(arr[m-1][i]+" ");
                }
                m--;
            }
            if(l<n){
                for(int i=m-1;i>=k;i--){
                    System.out.print(arr[i][l]+" ");
                }
                l++;
            }
        }

    }
}
