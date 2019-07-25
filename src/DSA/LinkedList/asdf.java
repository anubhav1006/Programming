package DSA.LinkedList;

public class asdf {

    class Add {

        // This function will add the numbers represented by two linked lists
        Node addTwoLists(Node first, Node second) {
            first = reverseList(first);
            second = reverseList(second);

            double a = 0, b = 0;
            a = num(first);
            b = num(second);

            return oppnum(a + b);
        }

        double num(Node head) {
            double res = 0;
            int counter = 0;
            while (head != null) {

                if (counter != 0) {
                    double val = power(10, counter);
                    res = res + val * head.data;
                } else
                    res += head.data;
                counter++;
                head = head.next;
            }

            return res;
        }

        double power(int num, int power) {
            double res = 1;
            while (power != 0) {
                res = res * num;
                power--;
            }
            return res;
        }

        Node oppnum(double data) {
            Node node = null, temp;
            while (data != 0) {
                double tempData = data % 10;
                if (node == null)
                    node = new Node((int) tempData);
                else {
                    temp = new Node((int) tempData);
                    temp.next = node;
                    node = temp;
                }
                data = data - tempData;
                data = data / 10;
            }
            return node;
        }

        Node reverseList(Node head) {
            Node prev = null, current = head, next;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }
    }
}
