package DSA.LinkedList;


import java.util.Scanner;

class FlattenList {
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    Node head;

    void printList(Node node) {
        //Node temp = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        FlattenList list = new FlattenList();
        while (t > 0) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            Node temp = null;
            Node tempB = null;
            Node pre = null;
            Node preB = null;
            int flag = 1;
            int flag1 = 1;
            for (int i = 0; i < N; i++) {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if (flag == 1) {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                } else {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for (int j = 0; j < m; j++) {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            //list.printList();
            GfG g = new GfG();
            Node root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;

	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of
    the flattened linked list. */
class GfG {
    FlattenList.Node flatten(FlattenList.Node root) {
        FlattenList.Node node = null;
        while (root.next != null) {
            FlattenList.Node temp = root;
            while (temp.bottom != null) {
                node.next = new FlattenList.Node(temp.data);
                temp = temp.next;
            }
            root = root.next;

        }
        return mergeSort(node);
    }

    FlattenList.Node mergeSort(FlattenList.Node h) {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list
        FlattenList.Node middle = getMiddle(h);
        FlattenList.Node nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        FlattenList.Node left = mergeSort(h);

        // Apply mergeSort on right list
        FlattenList.Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        FlattenList.Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    FlattenList.Node getMiddle(FlattenList.Node h) {
        // Base case
        if (h == null)
            return h;
        FlattenList.Node fastptr = h.next;
        FlattenList.Node slowptr = h;

        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null) {
            fastptr = fastptr.next;
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        return slowptr;
    }

    FlattenList.Node sortedMerge(FlattenList.Node a, FlattenList.Node b) {
        FlattenList.Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
}

