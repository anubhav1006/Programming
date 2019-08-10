package DSA.Trees;

import java.util.Vector;

public class ReplaceNodeSumInorderSuccessorPredecessor {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static Vector<Integer> arr = new Vector<>();

    static void Replace(Node root) {
        arr.add(0);
        inorderStore(root);
        arr.add(0);
        inorderReplace(root);

//2 9 3 11 4 13 3
    }
    static int i=1;

    static void inorderReplace(Node root){
        if(root==null)
            return;
        inorderReplace(root.left);
        int a = arr.elementAt(i-1);
        int b = arr.elementAt(i+1);
        root.data = a+b;
        i++;
        inorderReplace(root.right);

    }
    static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    static void inorderStore(Node root){
        if(root==null)
            return;
        inorderStore(root.left);
        arr.add(root.data);
        inorderStore(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);       //         1
        root.left = new Node(2);        //       /   \
        root.right = new Node(3);       //     2      3
        root.left.left = new Node(4);  //    /  \  /   \
        root.left.right = new Node(5); //   4   5  6   7
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Inorder before:");
        inorder(root);
        Replace(root);
        System.out.println("");
        System.out.println("Inorder after:");
        inorder(root);
    }
}
