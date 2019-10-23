package DSA.Graphs.MST;

import java.util.LinkedList;
import java.util.TreeSet;

public class Prim {

    class Graph{
        int v;
        LinkedList<Integer>[] adjList;

        Graph(int v){
            this.v = v;
            adjList = new LinkedList[v];

            for(int i =0;i<v;i++){
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, int dest){
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
    }

    static class MST{

        public static final int v =6;

        public void primMST(int[][] graph) {
            boolean[] spanned = new boolean[v];
            int[] minSpanSet = new int[v];

            int[] keySet = new int[v];

            for(int i=0;i<v;i++){
                keySet[i] = Integer.MAX_VALUE;
            }
            //Start of graph
            keySet[0]=0;
            minSpanSet[0]= -1;
            for(int i=0;i<v-1;i++) {
                int min_key = findMinKey(keySet,spanned);
                spanned[min_key] = true;

                for(int it = 0;it<v;it++){
                    if(graph[min_key][it]!=0 && keySet[it]>graph[min_key][it] && !spanned[it]){
                        keySet[it]=graph[min_key][it];
                        minSpanSet[it] = min_key;
                    }
                }

            }

            printMST(minSpanSet, graph);
        }

        private void printMST(int[] parent, int[][] graph) {
            System.out.println("Edge \tWeight");
            for (int i = 1; i < v; i++)
                System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }

        private int findMinKey(int[] keySet, boolean[] spanned) {
            int min=Integer.MAX_VALUE, min_index=-1;
            for(int i=0;i<v;i++){
                if(keySet[i]<min && !spanned[i]){
                    min = keySet[i];
                    min_index = i;
                }
            }
            return min_index;
        }
    }

    public static void main(String[] args) {
        MST t = new MST();
        int graph[][] = new int[][] {{0, 1, 1, 100, 0, 0},
                {1, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {100, 0, 0, 0, 2, 2},
                {0, 0, 0, 2, 0, 2},
                {0, 0, 0, 2, 2, 0}};


        t.primMST(graph);
    }
}
