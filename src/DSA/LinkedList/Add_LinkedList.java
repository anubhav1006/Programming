package DSA.LinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int d) {
        data = d;
        next = null;
    }
}

class Add_LinkedList {
    Node head;

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        // System.out.println("");
    }

    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n1 = sc.nextInt();
            Add_LinkedList list1 = new Add_LinkedList();
            for (int i = 1; i <= n1; i++) {
                int a = sc.nextInt();
                list1.push(a);
            }
            int n2 = sc.nextInt();
            Add_LinkedList list2 = new Add_LinkedList();
            for (int i = 0; i < n2; i++) {
                int b = sc.nextInt();
                list2.push(b);
            }
            Add_LinkedList list3 = new Add_LinkedList();
            Add g = new Add();
            Node rs = g.addTwoLists(list1.head, list2.head);
            list3.printList(rs);
            System.out.println();
            T--;
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*The Node is defined as
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
        Node(){}
    }
*/
class Add {
    Node addTwoLists(Node rev_first, Node rev_second) {
        Node result = rev_first;
        Node temp = null;
        int end = 0, load = 0;
        while (rev_first != null && rev_second != null) {
            if (rev_first.next == null) {
                end = 1;
                temp = rev_first;
            }
            if (rev_second.next == null) {
                end = 2;
                temp = rev_second;
            }
            if (rev_first.next == null && rev_second.next == null) {
                end = 0;
                temp = rev_first;
            }

            if (load > 0) {
                rev_first.data = rev_first.data + rev_second.data + load;
                load = 0;
            } else
                rev_first.data = rev_first.data + rev_second.data;
            if (rev_first.data > 9) {
                load = rev_first.data / 10;
                rev_first.data = rev_first.data % 10;

            }
            rev_first = rev_first.next;
            rev_second = rev_second.next;
        }
        if (end == 1) {
            temp.next = rev_second;
            rev_first = rev_second;
            while (load > 0) {
                rev_first.data += load;
                if (rev_first.data > 9) {
                    load = rev_first.data / 10;
                    rev_first.data = rev_first.data % 10;
                } else
                    load = 0;
            }
        }
        if (end == 2) {
            while (load > 0) {
                rev_first.data += load;
                if (rev_first.data > 9) {
                    load = rev_first.data / 10;
                    rev_first.data = rev_first.data % 10;
                }else
                    load = 0;
            }
        }
        if (end == 0 && load > 0) {
            temp.next = new Node(load);
        }
        return result;
    }

}