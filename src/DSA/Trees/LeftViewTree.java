package DSA.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeftViewTree {
    static class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
   public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            //Node root=null;
            while (t > 0)
            {
                HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
                int n = sc.nextInt();
                Node root=null;
                while (n > 0)
                {
                    int n1 = sc.nextInt();
                    int n2 = sc.nextInt();
                    char lr = sc.next().charAt(0);
                    Node parent = m.get(n1);
                    if (parent == null)
                    {
                        parent = new Node(n1);
                        m.put(n1, parent);
                        if (root == null)
                            root = parent;
                    }
                    Node child = new Node(n2);
                    if (lr == 'L')
                        parent.left = child;
                    else
                        parent.right = child;
                    m.put(n2, child);
                    n--;
                }
                System.out.println();
                leftView(root);
                System.out.println();
                t--;
            }
        }

    static void leftView(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node t = q.poll();
                if(i==0)
                    System.out.print(t.data+" ");
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
            }
        }
    }
}


