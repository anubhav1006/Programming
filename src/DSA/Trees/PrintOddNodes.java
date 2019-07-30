package DSA.Trees;

public class PrintOddNodes {
    static class node {
        int key;
        node left, right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static void printOddnodes(node root) {
        int h = height(root);
        for (int i = 1; i <= h; i += 2) {
            printOddnodesUtil(root, i);
        }
    }

    private static void printOddnodesUtil(node root, int i) {
        if (i == 1) {
            System.out.print(root.key + " ");
        }
        if(root.left!=null)
            printOddnodesUtil(root.left, i - 1);
        if(root.right!=null)
            printOddnodesUtil(root.right, i - 1);

    }

    static int height(node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.right = new node(6);
        root.left.right.left = new node(7);
        root.left.right.right = new node(8);
        root.right.right.left = new node(9);
        printOddnodes(root);


    }

}
