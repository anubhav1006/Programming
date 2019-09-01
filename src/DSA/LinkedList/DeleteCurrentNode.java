package DSA.LinkedList;

public class DeleteCurrentNode {

    public static void main(String[] args) {
        node head = new node(1);
        addNext(head,2);
        addNext(head,3);
        addNext(head,4);
        addNext(head,5);
        addNext(head,6);
        addNext(head,7);
        addNext(head,8);
        addNext(head,9);
        node toBeDeleted = head.next.next.next;
        System.out.println("Before conversion: ");
        printLL(head);
        System.out.println("");
        convert(toBeDeleted);
        System.out.println("After conversion: ");
        printLL(head);

    }

    private static void convert(node toBeDeleted) {
        if(toBeDeleted==null)
            return;
        if (toBeDeleted.next==null)
            toBeDeleted =null;
        node temp = toBeDeleted.next;
        toBeDeleted.next = toBeDeleted.next.next;
        toBeDeleted.data = temp.data;
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

}
