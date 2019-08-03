package DSA.Trees;

import java.util.LinkedList;

public class HeightOfEachNode {

    static class node {
        int key;
        node left, right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static int height(node root){
        if(root==null)
            return 0;

        return Math.max(height(root.left),height(root.right))+1;
    }

    static void inorder(node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.key+" - Height --> "+height(root));
        inorder(root.right);


    }

    public static void main(String[] args) {
        node root = new node(1);

        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
       inorder(root);
    }

}
