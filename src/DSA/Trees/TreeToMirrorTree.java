package DSA.Trees;

public class TreeToMirrorTree {
    static class node{
        int key;
        node left, right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static void convert(node root){
        if(root ==null)
            return;

        node temp = root.left;
        root.left = root.right;
        root.right = temp;

        convert(root.left);
        convert(root.right);
    }

    static void inorder(node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.key+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);

        convert(root);
        inorder(root);
    }
}
