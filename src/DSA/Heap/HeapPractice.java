package DSA.Heap;

public class HeapPractice {

    static class Heap{
        int[] heapArr;
        int heapSize=0;
        int capacity;

        public Heap(int capacity) {
            this.capacity = capacity;
            heapArr = new int[capacity];
        }

        int parent(int i){return (i-1)/2;}
        int left(int i){return 2*i+1;}
        int right(int i){return 2*i+2;}

        void MaxHeapify(int i){
            int l = left(i);
            int r = right(i);
            int max = i;

            if (l<heapSize && heapArr[l]>heapArr[i])
                max=l;
            if(r<heapSize && heapArr[r]>heapArr[max] ){
                max = r;
            }
            if (max!=i){
                swap(i,max);
                MaxHeapify(max);
            }
        }

        int extractMax() {
            int res;
            if (heapSize == 0)
                return Integer.MIN_VALUE;
            else if (heapSize == 1)
                return heapArr[--heapSize];
            else {
                res = heapArr[0];
                heapArr[0] = heapArr[--heapSize];

                MaxHeapify(0);
            }
            return res;
        }

        void DeleteKey(int i){
            decreaseKey(i, Integer.MAX_VALUE);
            extractMax();
        }

        void insertKey(int key){
            if(heapSize==capacity){
                System.out.println("heap overflow");
            }
            else{
                int i = heapSize;
                heapArr[heapSize++] = key;
                while(i!=0 && heapArr[parent(i)]<heapArr[i]){
                    swap(i, parent(i));
                    i=parent(i);
                }
            }
        }

        private void swap(int i, int parent) {
            int temp = heapArr[i];
            heapArr[i] = heapArr[parent];
            heapArr[parent] = temp;
        }

        private void decreaseKey(int i, int newK){
            heapArr[i] = newK;
            while (i!=0 && heapArr[parent(i)]<heapArr[i]){
                swap(i,parent(i));
                i=parent(i);
            }
        }

        private int getMax() {
            if (heapSize > 0)
                return heapArr[0];
            else
                return -1;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap(5);
        int i=0;
        while(h.heapSize<h.capacity){
            h.insertKey(++i);
        }
        while(h.heapSize>0){
            int temp = h.heapArr[0];
            h.heapArr[0] = h.heapArr[h.heapSize-1];
            h.heapArr[h.heapSize-1] = temp;
            h.heapSize--;
            h.MaxHeapify(0);
        }

        for(i=0;i<h.heapArr.length;i++){
            System.out.print(h.heapArr[i]+" ");
        }
    }
}
