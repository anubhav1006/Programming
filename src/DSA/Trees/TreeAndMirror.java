package DSA.Trees;

public class TreeAndMirror {
    static class node{
        int key;
        node left, right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static class BinaryTree{
        node a, b;

        boolean areMirror(node a, node b){
            if(a==null&&b==null)
                return true;
            else if((a==null && b!=null) || (a!=null&&b==null)){
                return false;
            }

            if(a.key!=b.key)
                return false;
            return areMirror(a.left, b.right) && areMirror(a.right,b.left);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        node a = new node(1);
        node b = new node(1);
        a.left = new node(2);
        a.right = new node(3);
        a.left.left = new node(4);
        a.left.right = new node(5);

        b.left = new node(4);
        b.right = new node(2);
        b.right.left = new node(5);
        b.right.right = new node(4);

        if (tree.areMirror(a, b))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
