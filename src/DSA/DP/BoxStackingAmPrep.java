package DSA.DP;

import java.util.Arrays;

public class BoxStackingAmPrep {

    public static void main(String[] args) {
        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);

        System.out.println("The maximum possible "+
                "height of stack is " +
                maxStackHeight(arr,4));
    }

    private static int maxStackHeight(Box[] arr, int n) {
        Box[] boxes = new Box[3*n];
        for(int i=0;i<n;i++){
            Box box = arr[i];
            boxes[3*i] = new Box(box.h,Math.max(box.w, box.d), Math.min(box.w, box.d));
            boxes[3*i+1] = new Box(box.w,Math.max(box.h, box.d), Math.min(box.h, box.d));
            boxes[3*i+2] = new Box(box.d,Math.max(box.h, box.w), Math.min(box.w, box.h));
        }

        for(int i=0;i<3*n;i++){
            boxes[i].area = boxes[i].w*boxes[i].d;
        }

        Arrays.sort(boxes);

        int count = 3*n;

        int msh[] = new int[count];

        for(int i=0;i<count;i++){
            msh[i] = boxes[i].h;
        }

        for(int i=0;i<count;i++){
            msh[i] = 0;
            int val =0;
            for(int j=0;j<i;j++){
                if(boxes[i].w<boxes[j].w && boxes[i].d<boxes[j].d){
                 val = Math.max(msh[j], val);
                }
            }
            msh[i]=val+boxes[i].h;
        }

        int max =0;
        for(int i=0;i<count;i++){
            if(max<msh[i])
                max=msh[i];
        }

        return max;

    }

    static class Box implements Comparable<Box>{
        int h, w, d, area;

        public Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
        }

        @Override
        public int compareTo(Box o) {
            return o.area-this.area;
        }
    }
}
