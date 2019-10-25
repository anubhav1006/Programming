package DSA.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesSameLevel {

    static class Node{
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

        // Populates nextRight pointer in all nodes
        connect(root);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in \n" +
                "the tree (-1 is printed if there is no nextRight)");
        System.out.println("nextRight of "+ root.data +" is "+
                ((root.nextRight != null) ? root.nextRight.data : -1));
        System.out.println("nextRight of "+ root.left.data+" is "+
                ((root.left.nextRight != null) ? root.left.nextRight.data : -1));
        System.out.println("nextRight of "+ root.right.data+" is "+
                ((root.right.nextRight != null) ? root.right.nextRight.data : -1));
        System.out.println("nextRight of "+  root.left.left.data+" is "+
                ((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1));
        System.out.println("nextRight of "+  root.right.right.data+" is "+
                ((root.right.right.nextRight != null) ? root.right.right.nextRight.data : -1));
    }

    private static void connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp!=null) {
                temp.nextRight = q.peek();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            else if(!q.isEmpty())
                q.add(null);
        }
    }
}
