package DSA.Trees;

public class MorrisTraversalInorder {

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);

        morrisTraverse(root);
    }

    private static void morrisTraverse(node root) {
        node current = root;

        while(current!=null){
            if(current.left==null){
                System.out.print(current.key+" ");
                current = current.right;
            }else {
                node next = current.left;
                while (next.right != null && next.right!= current) {
                    next = next.right;
                }
                if(next.right==null) {
                    next.right=current;
                    current = current.left;
                }else{
                     next.right = null;
                    System.out.print(current.key+" ");
                    current = current.right;
                }

            }
        }
    }

    static class node{
        int key;
        node left,right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }
}
