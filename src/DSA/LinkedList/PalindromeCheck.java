package DSA.LinkedList;

public class PalindromeCheck {

        static class Node{
             Node(Character c) {
                this.character = c;
            }

            Node next;
            Character character;
        }

         static void push(Node head, Character c){
            if(head == null){
                head = new Node(c);
            }
            while(head.next!=null){
                head = head.next;
            }
            head.next = new Node(c);
        }

        static boolean checkPalindrome(Node head){

            Node fastPtr = head, slowPtr = head;
            Node prevSlowPtr = null;
            Node midNode;
            if((head.next == null) || (head.next.next ==null))
                return true;

            while(fastPtr.next != null && fastPtr.next.next!=null){
                fastPtr = fastPtr.next.next;
                prevSlowPtr = slowPtr;
                slowPtr = slowPtr.next;
            }
            /*if(fastPtr.next != null){
                midNode = slowPtr;
            }*/

            prevSlowPtr.next = null;


            Node secondHalf = reverse(slowPtr.next);
            return compareLists(head, secondHalf);

        }

    private static boolean compareLists(Node head, Node secondHalf) {
            Node temp1 = head;
            Node temp2= secondHalf;

            while(temp1!=null && temp2!=null){
                if(temp1.character.compareTo(temp2.character)!=0)
                    return false;
                temp1= temp1.next;
                temp2 = temp2.next;
            }

            return true;
    }

    static Node reverse(Node head){
            if(head.next==null)
                return head;

            Node prev = null, current, next;

            current = head;

            while(current!=null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }


    public static void main(String[] args) {
        Node node = new Node('a');

        push(node, 'b');
        push(node, 'c');
        push(node,'b');
        push(node, 'a');

        System.out.println(checkPalindrome(node)+"");


    }
}
