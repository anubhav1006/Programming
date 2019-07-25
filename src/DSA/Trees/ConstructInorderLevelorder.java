package DSA.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructInorderLevelorder {
    static class node {
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};

        node root = constructTree(in, level, 0, in.length - 1);
        inorder(root);
        System.out.println("");
        levelOrder(root);
        System.out.println("");
        postorder(root);
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

    //static int le
    private static node constructTree(int[] in, int[] level, int start, int end) {

        if (start > end)
            return null;
        if (start == end)
            return new node(in[start]);

        node root = null;
        int divide = -1;

        for (int i = 0; i < level.length; i++) {
            node t = new node(level[i]);
            for (int j = start; j <= end; j++) {
                if (in[j] == t.data) {
                    divide = j;
                    root = new node(in[j]);
                    break;
                }
            }
            if (divide != -1)
                break;
        }

        if (root != null)
            root.left = constructTree(in, level, start, divide - 1);
        root.right = constructTree(in, level, divide + 1, end);

        return root;

    }
}
