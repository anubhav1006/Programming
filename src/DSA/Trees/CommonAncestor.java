package DSA.Trees;

import java.util.HashSet;
import java.util.Set;

public class CommonAncestor {
    static class Node{
        int key;
        Node left,right;
        boolean fire;
        boolean highestDepth;

        public Node(int key) {
            this.key = key;
            left=right=null;
        }
    }
    static Node lca;


    static Set<Node> list1 = new HashSet<>();
    static Set<Node> list2 = new HashSet<>();

    static int findCommonAncestor(Node root){
        int l = 0, r=0;
        if(root == null)
            return 0;
        if(root.fire || root.highestDepth){
            return 1;
//            if (root.fire) {
//                list1.add(root);
//                return 1;
//            } else {
//                list2.add(root);
//                return 2;
//            }
        }
        if(root.left!= null){
             l = findCommonAncestor(root.left);

        }
        if(root.right!=null) {
             r = findCommonAncestor(root.right);
        }
        if(l!=0 && r!=0){
            lca = root;
        }
        if(l!=0 || r!=0) {
            int a = (l!=0 && r!=0) ? 0 : l!=0 ? l : r;
            return a;
        }

        return  0;

    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.left.left  = new Node(8);
        root.left.left.left.right  = new Node(13);
        root.left.left.left.left.left  = new Node(9);
        root.left.left.left.left.left.left = new Node(10);
        root.left.left.left.left.left.left.highestDepth = true;
        root.left.left.left.right.fire=true;
        findCommonAncestor(root);
        if(lca!=null)
            System.out.println(lca.key);
        else{
            System.out.println("Not found" +
                    "");
        }

    }
}
