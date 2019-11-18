package DSA.Arrays;

import java.util.Arrays;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {5,2, 67, 34, 76, 345};
        int k=4;

        System.out.println("Kth largest element: "+ kthLargest(arr, k));
        System.out.println(Arrays.toString(heap));
    }

    private static int kthLargest(int[] arr, int k) {
        initHeap(k);
        for(int i=0;i<k;i++){
            heap[i] = arr[i];
        }
        heapify(0);
        for(int i=k;i<arr.length;i++){
            if(arr[i]>heap[0]) {
                heap[0] = arr[i];
                heapify(0);
            }
        }
        return heap[0];
    }
    private static int[] heap;
    private static int heapSize;
    private static int left(int i){return (2*i)+1;}
    private static int right(int i){return (2*i)+2;}
    private static int parent(int i){return (i-1)/2;}

    private static void initHeap(int size){
        heapSize = size;
        heap = new int[heapSize];
    }

    private static void heapify(int i){
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if(l<heapSize && heap[l]<heap[smallest])
            smallest=l;
        if(r<heapSize && heap[r]<heap[smallest])
            smallest=r;

        if (smallest!=i){
            swap(smallest, i);
            heapify(smallest);
        }
    }

    private static void swap(int smallest, int i) {
        int temp = heap[smallest];
        heap[smallest] = heap[i];
        heap[i] = temp;
    }

    private static int extractMin(){
        int min = heap[0];
        heap[0] = heap[heapSize-1];
        heapSize--;
        heapify(0);
        return min;
    }

}
