package DSA.Trees.BST;

 public class AVLTrees {

    static class Node{
        int key, height;
        Node left, right;

        Node(int key){
            this.key = key;
            height = 1;
            left = right = null;
        }
    }

     static Node insert(Node root, int key){
        if(root== null){
            return new Node(key);
        }

        if(key<root.key)
            root.left = insert(root.left, key);
        else if(key>root.key)
            root.right = insert(root.right, key);

        else if(key==root.key)
            return root;

        root.height = 1+ Math.max(height(root.left), height(root.right));

        int balance = balance(root);

        if(balance > 1 &&  key<root.left.key){
            return rotateRight(root);
        }
        if(balance <-1 &&  key>root.right.key){
            return rotateLeft(root);
        }if(balance > 1 &&  key>root.key){
            rotateLeft(root.left);
           return rotateRight(root);
        }
        if(balance<-1 &&  key<root.key){
            rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

     static private Node rotateLeft(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;
        x.height = Math.max(height(x.left), height(x.right));
        y.height = Math.max(height(y.left), height(y.right));
        return x;
     }

     static private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

         x.height = Math.max(height(x.left), height(x.right));
         y.height = Math.max(height(y.left), height(y.right));

         return x;
    }

     static private int balance(Node y) {
        if(y==null)
            return 0;
        return height(y.left) - height(y.right);
    }

     static private int height(Node node) {
        if(node == null)
            return 0;
        return node.height;
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root = insert(root, 1);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 4);
        System.out.println("a");
    }
}
