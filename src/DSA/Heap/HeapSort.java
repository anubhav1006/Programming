package DSA.Heap;

public class HeapSort {
    private void sort(int[] arr, int n){
        for(int i=(n/2)-1;i>=0;i--){
            heapify(arr,i,n);
        }

        for(int i= n-1; i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    private void heapify(int[] arr, int i, int n) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if(l<n && arr[l] > arr[i]){
            largest = l;
        }
        if(r<n && arr[r] > arr[largest]){
            largest = r;
        }
        //Integer.M
        if(largest!=i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest]= temp;
            heapify(arr,largest,n);
        }
    }

    private int right(int i) {
        return 2*i+2;
    }

    private int left(int i) {
        return 2*i+1;
    }

    public static void main(String[] args) {
        int[] array = {7, 8, 2, 9, 1};
        HeapSort sort = new HeapSort();
        sort.sort(array, 5);
        System.out.println("f");
    }
}
