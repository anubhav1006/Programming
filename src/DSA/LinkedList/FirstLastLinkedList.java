package DSA.LinkedList;

public class FirstLastLinkedList {
    public static void main(String[] args) {
        node node = new node(1);
        addNext(node,2);
        addNext(node,3);
        addNext(node,4);
        addNext(node,5);
        addNext(node,6);
        addNext(node,7);
        addNext(node,8);
        addNext(node,9);
        System.out.println("Before conversion: ");
        printLL(node);
        System.out.println("");
        convert(node);
        System.out.println("After conversion: ");
        printLL(node);

    }

    static class node{
        int data;
        node next;

        public node(int data) {
            this.data = data;
            next = null;
        }
    }

    static void printLL(node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    static void addNext(node head, int data){
        if(head ==null)
            head = new node(data);
        while(head.next!=null){
            head = head.next;
        }
        head.next = new node(data);
    }

    static void convert(node head){
        if(head==null || head.next==null)
            return;
        node mid = getMiddle(head);
        node head2 = mid.next;
        mid.next = null;

        head2 = reverseLL(head2);
        node head1 = head;
        while(head2!=null){
            node temp = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = temp;
            head1= head1.next.next;
        }

    }

    static node getMiddle(node head){
        if(head.next.next==null)
            return head.next;
        node fast_ptr = head, slow_ptr = head;
        while(fast_ptr.next!=null && fast_ptr.next.next!=null){
            fast_ptr=fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        return slow_ptr;
    }

    static node reverseLL(node head){
        node prev=null, current = head, next;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
