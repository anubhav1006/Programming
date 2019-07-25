package DSA.Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class DijkstraAdjacency {

    static class Graph{
        int v;
        LinkedList<node>[] adjList;

        public Graph(int v) {
            this.v = v;
            adjList = new LinkedList[v];
            for(int i=0;i<v;i++){
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, int dest, int weight){
            node nSrc = new node(src, weight);
            node nDest = new node(dest, weight);

            adjList[src].add(nDest);
            adjList[dest].add(nSrc);
        }
    }

    static class node{
        int dest;
        int weight;

        public node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class node0{
        int vertex;
        int key;
    }

    static class comparator implements Comparator<node0>{

        @Override
        public int compare(node0 o1, node0 o2) {
            return o1.key - o2.key;
        }
    }

    static void dj(Graph g, int src){
        int v = g.v;
        LinkedList<node>[] adjList = g.adjList;
        int[] parent = new int[v];
        Arrays.fill(parent, -1);
        boolean[] spt = new boolean[v];
        node0[] e = new node0[v];

        for(int i=0;i<v;i++){
            e[i] = new node0();
            e[i].vertex = i;
            e[i].key = Integer.MAX_VALUE;
        }
        e[src].key=0;

        TreeSet<node0> queue = new TreeSet<>(new comparator());

        queue.addAll(Arrays.asList(e));

        while(!queue.isEmpty()){
            node0 n = queue.pollFirst();
            spt[n.vertex]=true;
            for(node it:adjList[n.vertex]){
                if(!spt[it.dest]){
                    if(e[it.dest].key>e[n.vertex].key+it.weight){
                        parent[it.dest] = n.vertex;
                        queue.remove(e[it.dest]);
                        e[it.dest].key = e[n.vertex].key+it.weight;
                        queue.add(e[it.dest]);
                    }
                }
            }
        }

        for(int i=0;i<v;i++){
            System.out.print(0+" -- "+e[i].vertex+" --> "+e[i].key+"  Path--> 0-");
            printPath(parent, i);
            System.out.println("");
        }
    }

    private static void printPath(int[] parent, int i){
        if(parent[i]==-1)
            return;

        printPath(parent, parent[i]);
        System.out.print(i+"-");

    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        dj(g,0);
    }

}
