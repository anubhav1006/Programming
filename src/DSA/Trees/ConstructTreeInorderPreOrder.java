package DSA.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeInorderPreOrder {

    static class node {
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    class Tree {
        node root;

        void setLeft(int data, node n) {
            n.left = new node(data);
        }

        void setRight(int data, node n) {
            n.right = new node(data);
        }

    }
    static int counter =0;
    static node constructTree(int[] in, int[] pre, int start, int end) {
        int n = pre.length;
        if(start>end)
            return null;
        node root = new node(pre[counter++]);
        if (start == end)
            return new node(in[start]);

        int divide = -1;
        for (int i = start; i <= end; i++) {
            if (in[i] == root.data) {
                divide = i;
                break;
            }
        }
        root.left = constructTree(in, pre, start, divide - 1);
        root.right = constructTree(in, pre, divide + 1, end);

        return root;
    }

    static void levelOrder(node root) {
        if (root == null)
            return;
        Queue<node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node it = queue.poll();
            System.out.print(it.data + " ");
            if (it.left != null)
                queue.add(it.left);
            if (it.right != null)
                queue.add(it.right); 

        }
    }
    static void inorder(node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int in[] = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
        int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };

        node root = constructTree(in, pre, 0, in.length - 1);
        inorder(root);
    }
}
