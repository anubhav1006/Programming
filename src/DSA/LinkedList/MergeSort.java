package DSA.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class MergeSort {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static void push(Node head, int data) {
        if (head == null)
            head = new Node(data);

        while (head.next != null) {
            head = head.next;
        }
        head.next = new Node(data);

    }

    static Node mergeSort(Node head) {
        //Node result = head;
        if (head == null || head.next == null) {
            return head;
        }
        Node mid, head2;
        if (head.next.next == null) {
            head2 = head.next;
            head.next = null;
        } else {
            mid = middleElement(head);
            head2 = mid.next;
            mid.next = null;
        }
        //splitList(head, mid);

        Node left = mergeSort(head);
        Node right = mergeSort(head2);
        return merge(left, right);
    }

    private static Node merge(Node head, Node head2) {
        if (head == null) return head2;
        if (head2 == null) return head;
        if (head.data < head2.data) {
            head.next = merge(head.next, head2);
            return head;
        } else {
            head2.next = merge(head, head2.next);
            return head2;
        }
    }

    private static Node middleElement(Node head) {
        if (head == null)
            return null;
        Node fastptr = head, slowptr = head;
        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
        }
        return slowptr;
    }

    private static Node midElement(Node head){
        if(head==null)
            return null;
        Node slow=head, fast=head;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static void printList(Node head) {
        if (head == null)
            System.out.println("List is empty");
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(4);
        push(node, 2);
        push(node, 1);
        push(node, 5);
        push(node, 0);
        node = mergeSort(node);
        printList(node);

        //System.out.println(midElement(node).data);

        Set<Node> nodeSet= new HashSet<>();

    }
}
