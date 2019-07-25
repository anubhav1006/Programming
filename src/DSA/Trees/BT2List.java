package DSA.Trees;

public class BT2List {

    static class node{
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static node treetoList(node n) {
        if (n == null)
            return null;
        node root = treetoListUtil(n);

        for(;root.left!=null;root = root.left);
        return root;
    }

    private static node treetoListUtil(node n) {
        if(n==null)
            return null;
        if(n.left!=null){
            node left = treetoListUtil(n.left);
            for(;left.right!=null;left=left.right);
            left.right = n;
            n.left = left;
        }
        if(n.right!=null){
            node right = treetoListUtil(n.right);
            for(;right.left!=null;right = right.left);
            right.left = n;
            n.right = right;
        }

        return n;
    }
    static void printList(node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public static void main(String[] args) {

        node root = new node(10);
        root.left = new node(12);
        root.right = new node(15);
        root.left.left = new node(25);
        root.left.right = new node(30);
        root.right.left = new node(36);

        // Convert to DLL
        node head = treetoList(root);

        // Print the converted list
        printList(head);
    }
}
