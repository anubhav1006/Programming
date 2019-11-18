package DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CloneWithNextandRandom {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(new Node(5));
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
                list.head.next.next.next;
        list.head.next.next.random =
                list.head.next.next.next.next;
        list.head.next.next.next.random =
                list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
                list.head.next;

        // Making a clone of the original linked list.
        LinkedList clone = list.clone();

        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        clone.print();
    }

    static class Node{
        int data;
        Node next,random;

        public Node(int data) {
            this.data = data;
            next = random = null;
        }
    }

    static class LinkedList{
        Node head;

        public LinkedList(Node head) {
            this.head = head;
        }

        void push(int data){
            Node it = head;
            while(it.next!=null){
                it = it.next;
            }
            it.next = new Node(data);
        }

        void print(){
            Node temp = head;
            while (temp != null)
            {
                Node random = temp.random;
                int randomData = (random != null)? random.data: -1;
                System.out.println("Data = " + temp.data +
                        ", Random data = "+ randomData);
                temp = temp.next;
            }
        }

        public LinkedList clone(){

            Node it = head;
            while(it!=null){

                Node temp = it.next;
                it.next = new Node(it.data);
                it.next.next = temp;

                it = it.next.next;
            }

            Node head1 = head;
            Node head2 = head.next;
            while (head1!=null && head2!=null) {
                if (head1.random != null)
                    head2.random = head1.random.next;

                head1 = head1.next.next;
                if(head1!=null)
                    head2 = head2.next.next;
            }

             head1 = head;
             head2 = head.next;
            it = head2;
            while (head1!=null && head2!=null)
            {
                /*if(head1.random!=null)
                    head2.random = head1.random.next;*/
                head1.next = head1.next.next;
                if(head2.next!=null) {
                    head2.next = head2.next.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            return new LinkedList(it);
        }
    }
}
