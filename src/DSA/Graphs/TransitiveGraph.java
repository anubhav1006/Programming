package DSA.Graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TransitiveGraph

{
    static class Graph{
        int v;
        LinkedList<Integer>[] ll;
        int[][] reachMatrix;

        Graph(int v){
            this.v = v;
            ll= new LinkedList[v];
            for(int i=0;i<v;i++){
                ll[i] = new LinkedList<>();
            }

            reachMatrix = new int[v][v];
        }
        private void addEdge(int src, int dest) {
            ll[src].add(dest);
        }


        void transitive(){
            for(int i=0;i<v;i++){
                dfsUtil(i,i);
            }

            for(int i=0;i<v;i++){
                System.out.println(Arrays.toString(reachMatrix[i]));
            }
        }

        private void dfsUtil(int s, int d) {
            reachMatrix[s][d] =1;
           /* Iterator<Integer> it = ll[s].listIterator();
            while (it.hasNext()){
                d = it.next();
                if(reachMatrix[s][d]==0){
                    dfsUtil(s,d);
                }
            }*/
           for(int it:ll[v]){
               if(reachMatrix[s][it]==0){
                   dfsUtil(s, it);
               }
           }

        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.transitive();


    }
}
