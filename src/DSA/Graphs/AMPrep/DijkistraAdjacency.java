package DSA.Graphs.AMPrep;

import java.util.*;

public class DijkistraAdjacency {

    public static void main(String[] args) {
        graph g = new graph(9);
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

    private static void dj(graph g, int src) {
        node0[] edges = new node0[g.v];
        int[] parent = new int[g.v];
        for(int i=0;i<g.v;i++){
            edges[i] = new node0();
            edges[i].key = Integer.MAX_VALUE;
            edges[i].vertex = i;
            parent[i] = -1;
        }
        edges[src].key =0;

        boolean[] sptSet = new boolean[g.v];

        Comparator<node0> comparator  = Comparator.comparingInt((node0 o) -> o.key);

        TreeSet<node0> q = new TreeSet<>(comparator);
        q.addAll(Arrays.asList(edges));


        while (!q.isEmpty()){
            node0 n = q.pollFirst();
            sptSet[n.vertex] = true;
            Iterator<node> it = g.adjList[n.vertex].listIterator();
            while (it.hasNext()){
                node node = it.next();
                if(!sptSet[node.vertex] && edges[node.vertex].key>edges[n.vertex].key+node.key){

                    parent[node.vertex] = n.vertex;
                    q.remove(edges[node.vertex]);
                    edges[node.vertex].key = edges[n.vertex].key+node.key;
                    q.add(edges[node.vertex]);
                }
            }

        }

        for(int i=0;i<g.v;i++){
            System.out.print(src+" -- "+edges[i].vertex+" --> "+edges[i].key+"  Path--> 0-");
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
    private static int minKey(node0[] edges, boolean[] sptSet) {
        int min =Integer.MAX_VALUE;
        int min_idx = -1;
        for(int i=0;i<edges.length;i++){
            if(edges[i].key<min && !sptSet[i]){
                min = edges[i].key;
                min_idx = i;
            }
        }
        return min_idx;
    }

    static class comparator implements Comparator<node0>{

        @Override
        public int compare(node0 o1, node0 o2) {
            return o1.key - o2.key;
        }
    }
    static class graph{
        int v;
        LinkedList<node>[] adjList;

        public graph(int v) {
            this.v = v;
            adjList = new LinkedList[v];
            for(int i=0;i<v;i++){
                adjList[i] = new LinkedList<>();
            }
        }

        private void addEdge(int src, int dest, int weight){
            node nSrc = new node(src, weight);
            node nDest = new node(dest, weight);

            adjList[src].add(nDest);
            adjList[dest].add(nSrc);
        }

    }

    static class node{
        int vertex;
        int key;

        public node(int vertex, int weight) {
            this.vertex = vertex;
            this.key = weight;
        }
    }

    static class node0{
        int vertex;
        int key;
    }
}
