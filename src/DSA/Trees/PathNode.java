package DSA.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class PathNode {
    static class node {
        int key;
        node left, right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static boolean hasPath(node root, int data, ArrayList<Integer> arr) {
        if (root == null) {
            return false;
        }
        arr.add(root.key);
        if (root.key == data) {
            return true;
        }
         if(hasPath(root.left, data, arr) || hasPath(root.right, data, arr))
             return true;

         arr.remove(arr.size()-1);
         return false;
    }

    public static void main(String[] args) {
        node root=new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);
        int x=5;
        PrintPath(root, 6);
    }

    private static void PrintPath(node root, int x) {
        ArrayList<Integer> arr = new ArrayList<>();

        if(hasPath(root, x,arr)){

            for(int i: arr){
                System.out.print(i+" ");
            }
        }
    }
}
