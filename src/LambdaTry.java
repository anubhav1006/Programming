import java.util.ArrayList;
import java.util.Collections;

public class LambdaTry {

    static class Customer{
        String id;

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        String name;
    }

    static class Order{
        Customer c;
        int orderNo;
        String item;
        long price;

        public Order(Customer c, int orderNo, String item, long price) {
            this.c = c;
            this.orderNo = orderNo;
            this.item = item;
            this.price = price;
        }

        public Order(Customer c, int orderNo, String item) {
            this.c = c;
            this.orderNo = orderNo;
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Customer a = new Customer("a1", "a");
        Customer b = new Customer("b1", "b");
        Customer c = new Customer("c1", "c");
        Customer d = new Customer("d1", "d");

        Order o1 = new Order(a, 1,"Graphic Card",10000);
        Order o2  =  new Order(b,2, "RAM",6000);
        Order o3  =  new Order(b,3, "HDD", 3000);
        Order o4  =  new Order(b,4, "Graphic Card", 10000);
        Order o5  =  new Order(c,5, "RAM",6000);
        Order o6  =  new Order(d,6, "Processor",8000);

        ArrayList<Order> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        list.add(o5);
        list.add(o6);
        Collections.sort(list, (o11, o21) -> Long.compare(o21.price, o11.price));

        System.out.println("");


    }
}
