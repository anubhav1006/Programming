package DSA.Trees;

import java.util.HashMap;
import java.util.Map;

public class VerticalSum {
    static class node {
        int key;
        node left, right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }
    static Map<Integer, Integer> map = new HashMap<>();
    static int maxWidthLeft=0, maxWidthRight=0;

    static void verticalSum(node root, int col){
        if(root==null)
            return;
        if(map.containsKey(col)){
            int val = map.get(col);
            map.put(col, val+root.key);
        }else{
            map.put(col, root.key);
        }
        if(col<0)
            maxWidthLeft--;
        if(col>0)
            maxWidthRight++;
        if(root.left!=null)
            verticalSum(root.left, col-1);
        if(root.right!=null)
            verticalSum(root.right, col+1);
    }

    static void Print(){
        while(maxWidthRight>=maxWidthLeft){
            System.out.print(map.get(maxWidthLeft)+" ");
            maxWidthLeft++;
        }
    }

    public static void main(String[] args) {
        node root=new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        verticalSum(root, 0);
        Print();
    }
}
