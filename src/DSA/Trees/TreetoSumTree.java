package DSA.Trees;

public class TreetoSumTree {
    static class node{
        int key;
        node left, right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static int convert(node root){
       if(root==null){
           return 0;
       }

       int data = root.key;
       root.key = convert(root.left)+convert(root.right);

       return data+root.key;

    }
    static void inorder(node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.key+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        node root = new node(10);
        root.left = new node(-2);
        root.right = new node(6);
        root.left.left = new node(8);
        root.left.right = new node(-4);
        root.right.left = new node(7);
        root.right.right = new node(5);

        convert(root);
        inorder(root);

    }
}
