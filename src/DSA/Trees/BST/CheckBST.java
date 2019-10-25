package DSA.Trees.BST;

public class CheckBST {

    static class Node {
        int data;
        Node left, right, nextRight;

        public Node(int key) {
            this.data = key;
            left = right = nextRight = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);

        System.out.println(checkBST(root,null,null));

    }

    private static boolean checkBST(Node root,Node l, Node r) {
        if (root==null)
            return true;

        if(l!=null && root.data<=l.data)
            return false;
        if(r!=null && root.data>=r.data)
            return false;

        return checkBST(root.left,l,root)&& checkBST(root.right, root, r);

    }
}
