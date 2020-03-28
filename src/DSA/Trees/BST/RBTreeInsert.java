package DSA.Trees.BST;

import DSA.Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class RBTreeInsert{
    enum Color{
        Red,Black
    }

    Node rootTree;
    public static class Node{
        Node left, right,parent;
        int key;
        Color color;
        Node(int key, Node parent){
            left = right = null;
            this.parent = parent;
            this.key = key;
            color = Color.Red;
        }
    }


    public void insert(int key, Node root){

        if(key<root.key){
            if(root.left!=null)
                insert(key, root.left);
            else {
                root.left = new Node(key, root);
                correctInsertionOrder(root.left);
            }
        }else{
            if(root.right!=null)
                insert(key, root.right);
            else {
                root.right = new Node(key, root);
                correctInsertionOrder(root.right);
            }
        }
    }

    public Node correctInsertionOrder(Node n){
        if(n.parent==null){
            n.color = Color.Black;
            return n;
        }
        if(n.parent.color == Color.Black){
            return n;
        }

        if(getUncle(n) !=null && getUncle(n).color == Color.Red){
            n.parent.color = Color.Black;
            getUncle(n).color = Color.Black;
            n.parent.parent.color = Color.Red;

            n.parent.parent = correctInsertionOrder(n.parent.parent);
        } else {
            if(checkLeft(n.parent)){
                if(checkLeft(n)){
                    Node g =n.parent.parent;
                    Node p = n.parent;
                    Node u = getUncle(n);
                    rightRotate(n.parent.parent);
                    swapColor(g);
                    swapColor(p);
                }else{
                    Node g =n.parent.parent;
                    Node p = n.parent;
                    Node u = getUncle(n);
                    leftRotate(n.parent);
                    rightRotate(n.parent.parent);
                    swapColor(g);
                    swapColor(n);
                }
            }else{
                if(checkLeft(n)){
                    Node g =n.parent.parent;
                    Node p = n.parent;
                    Node u = getUncle(n);

                    rightRotate(n.parent);
                    leftRotate(n.parent.parent);
                    swapColor(g);
                    swapColor(n);

                }else{
                    Node g =n.parent.parent;
                    Node p = n.parent;
                    Node u = getUncle(n);

                    leftRotate(n.parent.parent);
                    swapColor(g);
                    swapColor(p);
                }
            }
        }


        return n;
    }

    void leftRotate(Node n){
        Node temp = n.parent;
        n.parent = n.right;
        n.right = n.right.left;
        n.parent.left = n;
        n.parent.parent = temp;
        if(temp!=null)
            temp.right = n.parent;
        else{
            rootTree = n.parent;
        }
    }

    void swapColor(Node n){
        if(n.color == Color.Red)
            n.color=Color.Black ;
        else
            n.color=Color.Red;
    }

    boolean checkLeft(Node n){
        return n.parent.left == n;
    }

    boolean checkRight(Node n){
        return n.parent.right == n;
    }

    void rightRotate(Node n){
        Node temp = n.parent;
        n.parent = n.left;
        n.left = n.left.right;
        n.parent.right =n;
        n.parent.parent = temp;
        if(temp!=null)
            temp.left = n.parent;
        else
            rootTree = n.parent;
    }

    Node getUncle(Node n){
        if(n.parent.parent.left == n.parent)
            return n.parent.parent.right;

        return n.parent.parent.left;
    }

    void levelOrderTraversal(Node root){
        if(root==null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node it =  queue.poll();
            if(it==null){
                if(!queue.isEmpty()){
                    queue.add(null);
                    System.out.println("");
                }
            }else {
                System.out.print(it.key + ", "+it.color+"    ");
                if (it.left != null)
                    queue.add(it.left);
                if (it.right != null)
                    queue.add(it.right);
            }
        }
    }


    public static void main(String[] args) {


        RBTreeInsert tree = new RBTreeInsert();

        tree.rootTree = new Node(7,null);
        tree.rootTree.color = Color.Black;

        tree.insert(3, tree.rootTree);
        tree.insert(8,tree.rootTree);
        tree.insert(10,tree.rootTree);
        tree.insert(11,tree.rootTree);
        tree.insert(18,tree.rootTree);
        tree.insert(22,tree.rootTree);
        tree.insert(26,tree.rootTree);
        tree.insert(2,tree.rootTree);
        tree.insert(6,tree.rootTree);
        tree.insert(13,tree.rootTree);

        tree.levelOrderTraversal(tree.rootTree);

    }
}
