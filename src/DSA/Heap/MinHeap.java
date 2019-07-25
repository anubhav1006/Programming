package DSA.Heap;

public class MinHeap {
    int[] arr;
    int capacity, heapSize;

    MinHeap(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        heapSize =0;
    }

    void insert(int key){
        if(heapSize==0){
            arr[heapSize] = key;
            heapSize++;
            return;
        }
        if(heapSize>=capacity){
            System.out.println("MinHeap overflow");
            return;
        }


        int i = heapSize;
        arr[i] = key;
        heapSize++;

        while(i!=0 && arr[parent(i)] > arr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    int rootElement(){
        if(heapSize==0) {
            System.out.println("Heap empty");
            return 0;
        }


        return arr[0];
    }
    void MinHeapify(int i){
        int l= left(i);
        int r = right(i);
        int smallest = i;

        if(l<heapSize && arr[l]< arr[i])
            smallest = l;
        if(r<heapSize && arr[r]<arr[smallest])
            smallest = r;

        if(smallest!=i){
            swap(i, smallest);
            MinHeapify(smallest);
        }

    }

    int extractMin(){
        if(heapSize==0){
            return Integer.MAX_VALUE;
        }
        if (heapSize==1){
            heapSize--;
            return arr[0];
        }
        int root = arr[0];
        arr[0] = arr[heapSize-1];
        MinHeapify(0);
        //decreasekey(heapSize, Integer.MIN_VALUE);

        return root;
    }

    private void decreasekey(int i, int newval) {
     arr[i] = newval;

     while(i!=0 && arr[i]<arr[parent(i)]){
         swap(i, parent(i));
         i = parent(i);
     }
    }

    void deletekey(int i){
        decreasekey(i, Integer.MIN_VALUE);
        extractMin();
    }

    private void swap(int i, int i1) {
        int temp = arr[i1];
        arr[i1] = arr[i];
        arr[i] = temp;
    }

    int parent(int i){
        return ((i-1)/2);
    }

    int left(int i){
        return ((2*i)+1);
    }

    int right(int i){
        return ((2*i)+2);
    }

    public static void main(String[] args) {
        //Kth largest element using heap

        int[] array = {7, 8, 2, 9, 1};
        int k = 0;

        MinHeap minHeap = new MinHeap(k);
        for(int i=0;i<k;i++){
            minHeap.insert(array[i]);
        }
        for(int i=k;i<array.length;i++){
            if(array[i]>minHeap.arr[0]) {
                minHeap.arr[0] = array[i];
                minHeap.MinHeapify(0);
            }
        }

        System.out.println(k+"th highest element: "+minHeap.arr[0]);


    }
}
