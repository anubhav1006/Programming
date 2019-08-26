package DSA.Trees;

import java.util.*;

public class DiagonalTraversal {
    static class node{
        int key;
        node left, right;

        public node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static void diagonalTraverse(node root){
        Map<Integer, Vector<node>> map = new HashMap<>();
        diagonalTraverseUtil(root, map,0);
        Set<Integer> it =  map.keySet();
        for(int i:it){
            Vector<node> levelVector = map.get(i);
            for(node n: levelVector){
                System.out.print(n.key+" ");
            }
            System.out.println("");
        }
    }

    private static void diagonalTraverseUtil(node root, Map<Integer, Vector<node>> map, int level ) {
        if(root==null)
            return;
        if(map.containsKey(level)){
            map.get(level).add(root);
        }else{
            map.put(level, new Vector<>());
            map.get(level).add(root);
        }
        diagonalTraverseUtil(root.left, map,level+1);
        diagonalTraverseUtil(root.right,map,level);

    }

    public static void main(String[] args) {
        node root = new node(8);
        root.left = new node(3);
        root.right = new node(10);
        root.left.left = new node(1);
        root.left.right = new node(6);
        root.right.right = new node(14);
        root.right.right.left = new node(13);
        root.left.right.left = new node(4);
        root.left.right.right = new node(7);

        diagonalTraverse(root);
    }
}
