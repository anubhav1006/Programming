package DSA.Trees;

import java.util.Stack;

public class MirrorTree {

    static class node{
        node left, right;
        int data;

        public node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        node root;

        public void mirror(node root) {
            if(root.left ==null || root.right==null)
                return;
            node temp = root.right;
            root.right = root.left;
            root.left = temp;
            mirror(root.left);
            mirror(root.right);
        }

        void inorder(node root){
            Stack<node> st = new Stack<>();
            node curr = root;

            while(curr!=null || !st.isEmpty()){
                while(curr!=null){
                    st.push(curr);
                    curr = curr.left;
                }
                node t = st.pop();
                System.out.print(t.data+", ");

                curr = t.right;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new node(1);
        tree.root.left = new node(2);
        tree.root.right = new node(3);
        tree.root.left.left = new node(4);
        tree.root.left.right = new node(5);
        tree.inorder(tree.root);
        tree.mirror(tree.root);
        System.out.println("");
        tree.inorder(tree.root);
    }
}
