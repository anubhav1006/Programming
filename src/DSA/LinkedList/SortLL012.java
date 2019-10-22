package DSA.LinkedList;

public class SortLL012 {
    static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class LinkedList {
        static node head;

        private static node sort() {
            node zero = head, one = head, two = head, it = head;

            while (two.next != null)
                two = two.next;

            while (it.next != null && it.next.next != null) {
                if (it.next.data == 0) {
                    node temp = zero.next;
                    zero.next = it.next;
                    it.next = it.next.next;
                    it.next.next = temp;
                    zero = zero.next;
                } else if (it.next.data == 1) {
                    node temp = one.next;
                    one.next = it.next;
                    it.next = it.next.next;
                    it.next.next = temp;
                    one = one.next;
                } else if (it.next.data == 2) {
                    node temp = it.next;
                    two.next = temp;
                    it.next = it.next.next;
                    two = two.next;
                    two.next = null;
                } else {
                    it = it.next;
                }
            }
            return head;
        }
    }


    public static void main(String[] args) {
        /*LinkedList ll = new LinkedList();
        ll.head = new node(1);
        ll.head.next = new node(2);
        ll.head.next.next = new node(2);
        ll.head.next.next.next = new node(1);
        ll.head.next.next.next.next = new node(2);
        ll.head.next.next.next.next.next = new node(0);
        ll.head.next.next.next.next.next.next = new node(2);
        ll.head.next.next.next.next.next.next.next = new node(2);

        printLL(ll.sort());*/

    }

    private static void printLL(node head) {
        while (head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
