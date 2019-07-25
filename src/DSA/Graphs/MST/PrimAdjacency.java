package DSA.Graphs.MST;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class PrimAdjacency {
    class node1{
        int dest;
        int weight;

        node1(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph{
        int v;
        LinkedList<node1>[] adjList;

        Graph(int v){
            this.v = v;
            adjList = new LinkedList[v];

            for(int i=0;i<v;i++){
                adjList[i] = new LinkedList<>();
            }
        }
    }

    class node{int vertex; int key;}

    class comparator implements Comparator<node>{

        @Override
        public int compare(node o1, node o2) {
            return o1.key - o2.key;
        }
    }

    void addEdge(Graph graph, int src, int dest, int weight){
        node1 node = new node1(src, weight);
        node1 node0 = new node1(dest, weight);
        graph.adjList[src].add(node0);
        graph.adjList[dest].add(node);
    }

    void prims_mst(Graph graph){
        boolean[] mstSet = new boolean[graph.v];
        node[] e = new node[graph.v];
        int[] parent = new int[graph.v];
        for(int i=0;i<graph.v;i++){
            e[i] = new node();
            e[i].key = Integer.MAX_VALUE;
            e[i].vertex = i;
            parent[i]=-1;
        }
        mstSet[0] = true;
        e[0].key=0;

        TreeSet<node> queue = new TreeSet<>(new comparator());
        queue.addAll(Arrays.asList(e));

        while(!queue.isEmpty()){
            node node0 = queue.pollFirst();

            mstSet[node0.vertex] = true;

            for(node1 node: graph.adjList[node0.vertex]){
                if(mstSet[node.dest]==false){
                    if(e[node.dest].key>node.weight){
                        queue.remove(e[node.dest]);
                        e[node.dest].key = node.weight;
                        queue.add(e[node.dest]);
                        parent[node.dest] = node0.vertex;
                    }
                }
            }

        }

        for(int i=1;i<graph.v;i++){
            System.out.println(parent[i]+" - "+i + " ->"+e[i].key);
        }

    }

    public static void main(String[] args) {
        int V = 9;

        Graph graph = new Graph(V);

        PrimAdjacency e = new PrimAdjacency();

        e.addEdge(graph, 0, 1, 4);
        e.addEdge(graph, 0, 7, 8);
        e.addEdge(graph, 1, 2, 8);
        e.addEdge(graph, 1, 7, 11);
        e.addEdge(graph, 2, 3, 7);
        e.addEdge(graph, 2, 8, 2);
        e.addEdge(graph, 2, 5, 4);
        e.addEdge(graph, 3, 4, 9);
        e.addEdge(graph, 3, 5, 14);
        e.addEdge(graph, 4, 5, 10);
        e.addEdge(graph, 5, 6, 2);
        e.addEdge(graph, 6, 7, 1);
        e.addEdge(graph, 6, 8, 6);
        e.addEdge(graph, 7, 8, 7);

        // Method invoked
        e.prims_mst(graph);
    }
}
