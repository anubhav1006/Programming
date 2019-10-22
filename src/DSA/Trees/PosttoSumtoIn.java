package DSA.Trees;

public class PosttoSumtoIn {
    public static void main(String[] args) {
        int[] tree = {1,7,5,50,40,10};
        int n = tree.length;
        node root = convertTree(tree,0,n);
        sumTree(root,0);
        printInorder(root);
    }

    private static void printInorder(node root) {
        if (root==null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    private static void sumTree(node root, int data) {
        if(root==null)
            return;
        int temp = root.data;
        root.data  =temp+data;
        sumTree(root.left,temp);
        sumTree(root.right,temp);
    }

    private static node convertTree(int[] tree,int start, int n) {
        if(start>=n || start<0)
            return null;

        node root;
        root = new node(tree[n-1]);
        /*if(n-start==3){
            root.left = new node(tree[start]);
            root.right = new node(tree[n-1]);
            return root;
        }*/
        int j=-1;
        if(start==3){
            System.out.println("");
        }
        for(int i=start;i<n;i++){
            if(tree[i]>tree[n-1]){
                j=i;
                break;
            }
        }

        root.left = convertTree(tree,start, j);
        root.right = convertTree(tree,j,n-1);


        return root;

    }

   static class node{
        node left, right;
        int data;

        public node(int data) {
            this.data = data;
            left = right = null;
        }
    }

}
