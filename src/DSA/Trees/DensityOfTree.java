package DSA.Trees;

public class DensityOfTree {

    static class node{
        int key;
        node left, right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }
    static int size = 0;

    static int height(node root){
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }

    static int heightSize(node root){
        if(root==null)
            return 0;
        int l = heightSize(root.left);
        int r = heightSize(root.right);
        size++;
        return 1+Math.max(l,r);
    }

    static int size(node root){
        if(root==null)
            return 0;
        return 1+size(root.left)+size(root.right);
    }

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);

        int height = heightSize(root);

        System.out.println((float)size/height);
    }
}
