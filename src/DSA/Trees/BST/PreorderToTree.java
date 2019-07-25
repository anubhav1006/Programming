package DSA.Trees.BST;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PreorderToTree {
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);
        return root;
    }

    static Node delete(Node root, int key) {

        if (root == null)
            return root;
        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }

        return root;
    }

    private static int minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.key;
    }

    private static Node deleteNode(Node node, int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node deleteNode = null, temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.key == key)
                deleteNode = temp;
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }

        if (temp.key != key) {
            deleteDeepest(node, temp);
            deleteNode.key = temp.key;
        } else
            deleteDeepest(node, temp);
        return node;
    }

    private static void deleteDeepest(Node node, Node temp) {

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node temp1 = q.poll();
            if (temp1.right != null) {
                if (temp1.right == temp) {
                    temp1.right = null;
                    return;
                } else
                    q.add(temp1.right);
            }
            if (temp1.left != null) {
                if (temp1.left == temp) {
                    temp1.left = null;
                    return;
                } else
                    q.add(temp1.left);
            }

        }
    }

    static int[] arr = new int[7];
    static int i = 0;

    private static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        arr[i] = root.key;
        inOrder(root.right);

        List<Integer> A = null;

        Iterator<Integer> itA = A.listIterator();
        itA.next();

        System.out.println(itA.hasNext());

    }

    public static void main(String[] args) {
        Node node = new Node(0);
        insert(node, 1);
        insert(node, 2);
        insert(node, 3);
        insert(node, 4);
        insert(node, -1);
        insert(node, -2);
        insert(node, -3);

        delete(node, 3);
        inOrder(node);

        //createTree
        System.out.println("a");

    }

    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int currentGas = 0;
        int currentStation = 0;
        int startIndex = 0;
        boolean flag = true;
        startIndex = findStart(A, B, startIndex);
        while (startIndex >= 0) {

            currentStation = startIndex;
            currentGas = B.get(startIndex);

            while (currentStation < startIndex) {

                if (currentGas - A.get(currentStation) > 0) {
                    currentGas -= A.get(currentStation);
                    currentStation++;
                } else {
                    flag = false;
                    break;
                }
                if (currentStation == A.size() - 1)
                    currentStation = 0;
            }
            if (!flag) {
                startIndex = findStart(A, B, startIndex + 1);
            }
        }
        return -1;
    }

    private int findStart(List<Integer> a, List<Integer> b, int startIndex) {
        Iterator<Integer> itA = a.listIterator(startIndex);
        Iterator<Integer> itB = b.listIterator(startIndex);
        boolean flag = false;
        while (itA.hasNext() && itB.hasNext()) {

            if (itA.next() < itB.next()) {
                flag = true;
                break;
            }
            startIndex++;
        }

        if (flag == true)
            return startIndex;
        else
            return -1;
    }
}
