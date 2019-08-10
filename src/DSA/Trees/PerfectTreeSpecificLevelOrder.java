package DSA.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PerfectTreeSpecificLevelOrder {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        void specificLevelTraversal() {
            Queue<Node> queue = new LinkedList<>();
            System.out.print(root.data + " ");
            queue.add(root.left);
            queue.add(root.right);
            System.out.print(root.left.data + " ");
            System.out.print(root.right.data + " ");
            while (!queue.isEmpty()) {
                Node t = queue.poll();
                Node t2 = queue.poll();
                System.out.print(t.left.data + " " + t2.right.data + " ");
                System.out.print(t.right.data + " " + t2.left.data + " ");
                if (t.left.left != null) {
                    queue.add(t.left);
                    queue.add(t2.right);
                    queue.add(t.right);
                    queue.add(t2.left);
                }

            }
        }

        void specificReverseLevelTraversalUtil(Stack<Node> stack) {
            Queue<Node> queue = new LinkedList<>();
            //System.out.print(root.data + " ");
            queue.add(root.left);
            queue.add(root.right);
            //System.out.print(root.left.data + " ");
            //System.out.print(root.right.data + " ");
            while (!queue.isEmpty()) {
                Node t = queue.poll();
                Node t2 = queue.poll();
                stack.push(t2.left);
                stack.push(t.right);
                stack.push(t2.right);
                stack.push(t.left);
                //System.out.print(t.left.data + " " + t2.right.data + " ");
                //System.out.print(t.right.data + " " + t2.left.data + " ");
                if (t.left.left != null) {
                    queue.add(t.right);
                    queue.add(t2.left);
                    queue.add(t.left);
                    queue.add(t2.right);
                }

            }
        }

        public void specificReverseLevelTraversal() {

            Stack<Node> stack = new Stack<>();
            stack.push(root);
            stack.push(root.left);
            stack.push(root.right);
            specificReverseLevelTraversalUtil(stack);

            while(!stack.isEmpty()){
                System.out.print(stack.pop().data+" ");
            }

        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);

        tree.root.left.left.left.left = new Node(16);
        tree.root.left.left.left.right = new Node(17);
        tree.root.left.left.right.left = new Node(18);
        tree.root.left.left.right.right = new Node(19);
        tree.root.left.right.left.left = new Node(20);
        tree.root.left.right.left.right = new Node(21);
        tree.root.left.right.right.left = new Node(22);
        tree.root.left.right.right.right = new Node(23);
        tree.root.right.left.left.left = new Node(24);
        tree.root.right.left.left.right = new Node(25);
        tree.root.right.left.right.left = new Node(26);
        tree.root.right.left.right.right = new Node(27);
        tree.root.right.right.left.left = new Node(28);
        tree.root.right.right.left.right = new Node(29);
        tree.root.right.right.right.left = new Node(30);
        tree.root.right.right.right.right = new Node(31);

        tree.specificReverseLevelTraversal();
    }
}
