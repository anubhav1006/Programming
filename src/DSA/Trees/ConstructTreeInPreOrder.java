package DSA.Trees;

public class ConstructTreeInPreOrder {

    static class node {
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static void main(String[] args) {
        int in[] =  new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
        int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
        int post[] =new int[] { 9, 8, 4, 2, 10, 5, 10, 6, 3, 13, 12, 7, 1};

        node root = constructTree(in, pre, 0, in.length - 1);
        node root2 = constructTreePost(in,post,0,in.length-1);
        inorder(root);
        System.out.println("");
        inorder(root2);
    }

    public static node mainly() {
        int in[] =  new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
        int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
        int post[] =new int[] { 9, 8, 4, 2, 10, 5, 10, 6, 3, 13, 12, 7, 1};

        node root = constructTree(in, pre, 0, in.length - 1);
        node root2 = constructTreePost(in,post,0,in.length-1);
        /*inorder(root);
        System.out.println("");
        inorder(root2);
        */
        return root;
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
    static int it1 = 12;
    private static node constructTreePost(int[] in, int[] post, int start, int end) {
        node root;

        if(start>=end)
            return null;
        root = new node(post[it1]);
        int i;
        for (i = start; i <=end; i++) {
            if(in[i]==post[it1]){
                break;
            }
        }
        it1--;
        root. right = constructTreePost(in,post,i+1, end);
        root.left = constructTreePost(in,post, start,i);

        return root;
    }

    private static void inorder(node root) {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    private static void postorder(node root) {
        if(root==null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data+" ");

    }

}
