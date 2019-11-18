package DSA.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class node{
        int key;
        node left,right;

        public node(int key) {
            this.key = key;
            left=right=null;
        }
    }

    static class Tree{
        node root;

        public Tree(int key) {
            this.root = new node(key);
        }

        public Tree(){}

        void inorder(node root){
            if(root==null)
                return;
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }

        void postorder(node root){
            if(root==null)
                return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key+" ");
        }

        void preorder(node root){
            if(root==null)
                return;
            System.out.print(root.key+" ");
            preorder(root.left);
            preorder(root.right);
        }

        int height(node root){
            if(root==null)
                return 0;

            return 1+ Math.max(height(root.left), height(root.right));
        }
        static void levelOrder(node root){
            if(root==null)
                return;
            Queue<node> queue = new LinkedList<node>();
            queue.add(root);
            queue.add(null);
            while(!queue.isEmpty()){
                node it =  queue.poll();
                if(it==null){
                    if(!queue.isEmpty()){
                        queue.add(null);
                        System.out.println("");
                    }
                }else {
                    System.out.print(it.key + " ");
                    if (it.left != null)
                        queue.add(it.left);
                    if (it.right != null)
                        queue.add(it.right);
                }
            }
        }

        void levelOrderUsingLevel(node root){
            int h = height(root);
            for(int i=1;i<=h;i++){
                printLevel(root, i);
            }
        }

        void levelOrderUsingLevelSpiral(node root){
            int h = height(root);
            for(int i=1;i<=h;i++){
                printLevelSpiral(root, i,i%2==0);
            }
        }

        void printLevel(node root, int h){
            if(h==1){
                System.out.print(root.key+" ");
            }
            if(root.left!=null)
                printLevel(root.left,h-1);
            if(root.right!=null)
                printLevel(root.right,h-1);
        }

        void printLevelSpiral(node root, int h, boolean counter){
            if(h==1){
                System.out.print(root.key+" ");
            }
            if(!counter) {
                if (root.left != null)
                    printLevelSpiral(root.left, h - 1,counter);
                if (root.right != null)
                    printLevelSpiral(root.right, h - 1,counter);
            }else{
                if (root.right != null)
                    printLevelSpiral(root.right, h - 1,counter);
                if (root.left != null)
                    printLevelSpiral(root.left, h - 1,counter);
            }
        }

    }



    public static void main(String[] args) {
        Tree tree = new Tree(0);
        tree.root.left = new node(1);
        tree.root.right = new node(2);
        tree.root.left.left = new node(3);
        tree.root.left.right = new node(4);
        tree.root.right.left = new node(5);
        tree.root.right.right = new node(6);

        /*System.out.println("Preorder: ");
        tree.inorder(tree.root);
        System.out.println("");
        System.out.println("Postorder:");
        tree.postorder(tree.root);
        System.out.println("");
        System.out.println("Preorder:");
        tree.preorder(tree.root);
        System.out.println("");
        System.out.println("LevelOrder:");
        tree.levelOrder(tree.root);
        System.out.println("");
        System.out.println("LevelOrder Using print level:");
        tree.levelOrderUsingLevel(tree.root);
        System.out.println("");
        System.out.println("LevelOrderSpiral:");*/
        tree.levelOrderUsingLevelSpiral(tree.root);

    }
}
