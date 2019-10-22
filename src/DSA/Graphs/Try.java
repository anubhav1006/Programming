package DSA.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

class Try
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle1().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
/*
ArrayList<ArrayList<Integer>> list: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle1
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        int[] par = new int[V];
        for(int i=0;i<V;i++){
            par[i]=-1;
        }
        int src=0;
        for(ArrayList<Integer> i: list){
            int k=0;
            for(int j: i){
                if(k==0){
                    src =j;
                    k++;
                }else{
                    int x =find(par, src);
                    int y =find(par, j);
                    if (x == y)
                        return true;

                    union(par,x,y);
                }


            }
        }
        return false;
    }

    static int find(int[] parent, int i){
        if(parent[i]==-1)
            return i;
        return find(parent, parent[i]);
    }
    static void union(int[] parent, int x, int y){
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }
}