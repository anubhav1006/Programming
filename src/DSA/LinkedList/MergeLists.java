package DSA.LinkedList;

import java.util.Scanner;

class MergeLists
{
    static class Node
    {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;
    public void addToTheLast(Node node)
    {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }



    /* Driver program to test above functions */
    public static void main(String args[])
    {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            MergeLists llist1 = new MergeLists();
            MergeLists llist2 = new MergeLists();

            int a1=sc.nextInt();
            Node head1= new Node(a1);
            llist1.addToTheLast(head1);
            if (sc.hasNextInt())
                for (int i = 1; i < n1; i++)
                {
                    //int a;

                    int a = sc.nextInt();
                    llist1.addToTheLast(new Node(a));
                }


            int b1=sc.nextInt();
            Node head2 = new Node(b1);
            llist2.addToTheLast(head2);
            if (sc.hasNextInt())
                for (int i = 1; i < n2; i++)
                {
                    //int b;

                    int b = sc.nextInt();
                    llist2.addToTheLast(new Node(b));
                }
            llist1.head= new LinkedList().sortedMerge(llist1.head,llist2.head);
            llist1.printList();

            t--;

        }
    }
    static class LinkedList
    {

        Node sortedMerge(Node headA, Node headB) {

            Node temp, temp2 = null, result = headA;
            while (headA != null && headB != null) {
                if (headA.data > headB.data) {
                    temp = headB.next;
                    headB.next = null;
                    if (temp2 == null) {
                        headB.next = headA;
                        result = headB;
                    }
                    else {
                        temp2.next = headB;
                        headB.next = headA;
                    }
                   // headA = headB;
                    headB = temp;
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

        Node recMergeSorted(Node head1, Node head2){
            if(head1==null)
                return head2;
            if(head2==null)
                return head1;
            if(head1.data<head2.data){
                head1.next = recMergeSorted(head1.next, head2);
                return head1;
            }else{
                head2.next = recMergeSorted(head1, head2.next);
                return head2;
            }
        }
    }

}


/*This is a function problem.You only need to complete the function given below*/
/*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
