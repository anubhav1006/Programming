package DSA.Trees;

public class MorrisTraversal {

    static class node{
        int key;
        node left,right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static void MorrisTraverseInorder(node root){
        if(root==null)
            return;
        while(root!=null) {
            if (root.left == null) {
                System.out.print(root.key + " ");
                root = root.right;
            } else {
                node left = root.left;
                while (left.right != null && left.right != root)
                    left = left.right;
                if (left.right == null) {
                    left.right = root;
                    root = root.left;
                }else {
                    left.right = null;
                    System.out.print(root.key+" ");
                    root = root.right;
                }

            }
        }

    }
    static void MorrisTraversePostOrder(node root){
        if(root==null)
            return;
        while(root!=null) {
            if (root.right == null) {
                System.out.print(root.key + " ");
                root = root.left;
            } else {
                node right = root.right;
                while (right.right != null && right.right != root)
                    right = right.left;
                if (right.left == null) {
                    right.left = root;
                    root = root.right;
                }else {
                    right.left = null;
                    System.out.print(root.key+" ");
                    root = root.left;
                }

            }
        }

    }


    static void MorrisTraversePreorder(node root){
        if(root==null)
            return;
        while(root!=null) {
            if (root.left == null) {
                System.out.print(root.key + " ");
                root = root.right;
            } else {
                node left = root.left;
                while (left.right != null && left.right != root)
                    left = left.right;
                if (left.right == null) {
                    left.right = root;
                    System.out.print(root.key+" ");
                    root = root.left;
                }else {
                    left.right = null;

                    root = root.right;
                }

            }
        }

    }

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);

        MorrisTraversePostOrder(root);
    }
}
