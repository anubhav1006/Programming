package DSA.Heap;

public class MaxHeap {
    int[] arr;
    int capacity, heapSize;

    MaxHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        heapSize = 0;
    }

    void insert(int key) {
        if (heapSize == 0) {
            arr[heapSize] = key;
            heapSize++;
            return;
        }
        if (heapSize >= capacity) {
            System.out.println("MinHeap overflow");
            return;
        }
        int i = heapSize;
        arr[i] = key;
        heapSize++;

        while (i != 0 && arr[parent(i)] < arr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    void MaxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < heapSize && arr[l] > arr[i])
            largest = l;
        if (r < heapSize && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            swap(i, largest);
            MaxHeapify(largest);
        }

    }

    int[] MaxHeapify(int i, int[] arr) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < heapSize && arr[l] > arr[i])
            largest = l;
        if (r < heapSize && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            swap(i, largest,arr);
            MaxHeapify(largest,arr);
        }

        return arr;

    }

    int extractMax() {
        if (heapSize == 0) {
            return Integer.MIN_VALUE;
        }
        if (heapSize == 1) {
            heapSize--;
            return arr[0];
        }
        int root = arr[0];
        arr[0] = arr[heapSize - 1];
        MaxHeapify(0);
        //decreasekey(heapSize, Integer.MIN_VALUE);

        return root;
    }

    private void decreasekey(int i, int newval) {
        arr[i] = newval;

        while (i != 0 && arr[i] < arr[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    void deletekey(int i) {
        decreasekey(i, Integer.MAX_VALUE);
        extractMax();
    }

    private void swap(int i, int i1) {
        int temp = arr[i1];
        arr[i1] = arr[i];
        arr[i] = temp;
    }

    private void swap(int i, int i1, int[] arr) {
        int temp = arr[i1];
        arr[i1] = arr[i];
        arr[i] = temp;
    }



    int parent(int i) {
        return ((i - 1) / 2);
    }

    int left(int i) {
        return ((2 * i) + 1);
    }

    int right(int i) {
        return ((2 * i) + 2);
    }

    public static void main(String[] args) {
        //Kth largest element using heap
        int[] array = {7, 8, 2, 9, 1};
        /*int k = 4;
        MaxHeap maxHeap = new MaxHeap(5);
        for (int i = 0; i < 5; i++)
            maxHeap.insert(array[i]);
        int val = 0;
        for (int i = 0; i < k; i++) {
            val = maxHeap.extractMax();
        }
        System.out.println("K'th largest element is: " + val);*/
        MaxHeap maxHeap = new MaxHeap(5);
        /*for(int i =0;i<array.length;i++){
            maxHeap.insert(array[i]);
        }*/

    }
}
