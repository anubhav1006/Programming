package DSA.Trees;

public class PrintLeaf {
    static class Node{
        LeftView.Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
