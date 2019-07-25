package DSA.LinkedList;

public class RemoveElement {

    static class Node {
        Node(int data) {
            this.data = data;
        }

        int data;
        Node next;

    }

    static void push(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        }
        while (head.next != null) {
            head = head.next;
        }
        head.next = new Node(data);
    }

    static void removeElementFromSorted(Node head) {

        while (head.next != null) {
            if (head.data == head.next.data) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
    }

    Node sortedMerge(Node headA, Node headB) {

        Node temp, temp2 = null, result = headA;
        while (headA != null && headB != null) {
            if (headA.data > headB.data) {
                temp = headB.next;
                headB.next = null;
                if (temp2 == null)
                    headB.next = headA;
                else {
                    temp2.next = headB;
                    headB.next = headA;
                }
                headB = headB.next;
            } else {
                temp2 = headA;
                headA = headA.next;
            }
        }
        if (headB != null) {
            headA = temp2;
            headA.next = headB;
        }
        return result;
    }

    public static void main(String[] args) {
        Node node = new Node(8);

        push(node, 10);
        push(node, 10);
        push(node, 10);
        push(node, 11);
        push(node, 12);

        Node node2 = new Node(6);

        push(node, 7);
        push(node, 9);
        push(node, 13);
        push(node, 14);
        push(node, 16);

        removeElementFromSorted(node);

        System.out.println("Done");

    }


}
