package DSA.Trees;

import java.util.*;

public class LeftView {
    static class Node{
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree{
        Node root;
        Map<Integer, Integer> map = new HashMap<>();

        public void leftView() {
            int maxLeft=0;
            int data =root.data;
            int level=0;

            leftViewUtil(root, maxLeft, level);
            printLeft(root, 0, 0);

        }

        private void leftViewUtil(Node root, int maxLeft, int level) {

            if(map.containsKey(level)){
                if(map.get(level)>maxLeft)
                    map.put(level, maxLeft);
            }else{
                map.put(level, maxLeft);
            }
            if(root.left!=null)
                leftViewUtil(root.left, maxLeft-1, level+1);
            if(root.right!=null)
                leftViewUtil(root.right, maxLeft+1, level+1);
        }



        private void printLeft(Node root, int maxLeft, int level){
            if(map.get(level)== maxLeft){
                System.out.print(root.data+" ");
            }
            if(root.left!=null)
                printLeft(root.left, maxLeft-1, level+1);
            if(root.right!=null)
                printLeft(root.right, maxLeft+1, level+1);
        }
    }

    static void leftView(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node t = q.poll();
                if(i==0)
                    System.out.print(t.data+" ");
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
            }
        }
    }

    static int max_level = 0;

    static void leftSideView(Node root, int level){
        if(root == null){
            return;
        }
        if(max_level < level){
            System.out.println(root.data + " ");
            max_level++;
        }
        leftSideView(root.left, level+1);
        leftSideView(root.right, level+1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        leftSideView(tree.root, 1);
        //leftView(tree.root);
    }
}
