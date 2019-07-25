package DSA.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructInorderPostorder {

    static class node{
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
        int post[] = new int[]{4, 10, 14, 12, 8, 22, 20};
        int postIndex = post.length-1;

        node root = constructTree(in, post, 0, in.length - 1);
        inorder(root);
        System.out.println("");
        levelOrder(root);
        System.out.println("");
        postorder(root);
    }

    static int postIndex=6;
    private static node constructTree(int[] in, int[] post, int start, int end) {
        if(start>end){
            return null;
        }
        node root = new node(post[postIndex--]);
        if(start==end){
            return new node(in[start]);
        }
        int divide = -1;
        for(int i=start;i<=end;i++){
            if(in[i]==root.data){
                divide = i;
                break;
            }
        }
        root.right = constructTree(in, post,divide+1,end);
        root.left = constructTree(in, post, start, divide-1);

        return root;
    }

    static void postorder(node root) {

        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }


    static void inorder(node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

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
}
