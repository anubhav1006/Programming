package DSA.Trees;

public class MorrisTraversalPreOrder {

    static class node {
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static void main(String[] args) {
       /* node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);*/

        int in[] =  new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
        int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };

        node root = constructTree(in, pre, 0, in.length - 1);

        MorrisTraversePreOrder(root);
    }

    static int it =0;
    private static node constructTree(int[] in, int[] pre, int start, int end) {
        node root;

        if(start>=end)
            return null;
        root = new node(pre[it]);
        int i;
        for (i = start; i <=end; i++) {
            if(in[i]==pre[it]){
                break;
            }
        }
        it++;
        root.left = constructTree(in,pre, start,i);
        root. right = constructTree(in,pre,i+1, end);
        return root;
    }

    private static void MorrisTraversePreOrder(node root) {
        node current = root;
        while (current!=null){
            //
            if(current.left==null){
                System.out.print(current.data+" ");
                current=current.right;
            }else {
                node next = current.left;
                while (next.right!=null && next.right!=current){
                    next = next.right;
                }

                if(next.right==null){
                    System.out.print(current.data+" ");
                    next.right=current;
                    current = current.left;

                }else {
                    next.right=null;
                    current = current.right;
                    //System.out.print(current.data+" ");
                }
            }
        }
    }
}
