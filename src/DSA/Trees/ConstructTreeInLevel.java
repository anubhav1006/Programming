package DSA.Trees;

import java.util.HashSet;
import java.util.Set;

public class ConstructTreeInLevel {
    public static void main(String[] args) {
        int in[]    = {4, 8, 10, 12, 14, 20, 22};
        int level[] = {20, 8, 22, 4, 12, 10, 14};

        node root = constructTree(in,0,in.length, level);
        printInorder(root);
    }

    private static node constructTree(int[] in,int start, int end, int[] level) {

        if(start>=end)
            return null;
        Set<Integer> set = new HashSet<>();

        node root = new node(level[0]);
        int pos=-1;
        for(int i=start;i<end;i++) {
            if (in[i] == level[0]) {
                pos = i;
                break;
            }
        }
        for(int i=start;i<pos;i++){
            set.add(in[i]);
        }
        int[] lTree = new int[set.size()];
        int[] rTree = new int[end-start-set.size()];
        int lit=0, rit=0;
        for(int i=1;i<level.length;i++){
            if(set.contains(level[i])){
                lTree[lit++]=level[i];
            }else {
                rTree[rit++]=level[i];
            }
        }

        root.left = constructTree(in,start,pos,lTree);
        root.right = constructTree(in,pos+1,end,rTree);
        return root;
    }

    private static void printInorder(node root){
        if (root==null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);

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
