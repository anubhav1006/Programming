package DSA.Graphs.MST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Kruskal {

    static class Graph {
        public int edgeCounter = 0;
        int v,e;
        Edge[] edges;

        Graph(int v,int e) {
            this.v = v;
            this.e = e;
            edges = new Edge[this.e];
        }


        class Edge implements Comparable<Edge>{
            int src, dest, weight;

            public Edge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }

            public Edge() {

            }

            @Override
            public int compareTo(Edge o) {
                return this.weight-o.weight;
            }
        }

        void addEdge(int src, int dest, int weight) {
            edges[edgeCounter++] = new Edge(src,dest,weight);
        }
    }

    static class Node{
        int data;
        int rank;
        Node parent;
    }

    static Map<Integer, Node> map = new HashMap<>();

    static Node findSet(int data){
        return map.get(data);
    }

    static void makeSet(int data){
        Node node = new Node();
        node.data = data;
        node.rank=0;
        node.parent = node;

        map.put(data,node);
    }

    static private Node findSet(Node x){
        Node parent = x.parent;
        if(parent==x)
            return parent;
        x.parent = findSet(parent);

        return x.parent;
    }

    static void unionSet(int data1, int data2){
        Node x = map.get(data1);
        Node y = map.get(data2);
        Node xSet =findSet(x);
        Node ySet = findSet(y);

        if(xSet==ySet)
            return;
        if(xSet.rank>ySet.rank)
            ySet.parent=xSet;
        else if(ySet.rank > xSet.rank){
            xSet.parent = ySet;
        }
        else{
            xSet.parent=ySet;
            ySet.rank++;
        }
    }

    static void Kruskal(Graph g){
        int v = g.v;
        int e = g.e;
        for(int i=0;i<v;i++){
            makeSet(i);
        }
        //Iterator for result array
        int r=0;
        Graph.Edge[] result = new Graph.Edge[v];
        Graph.Edge[] edges = g.edges;

        //Iterator for edges Array
        int it=0;
        Arrays.sort(edges);

        while(it<v-1){
            Graph.Edge nextEdge = edges[it++];
            Node x = findSet(nextEdge.src);
            Node y = findSet(nextEdge.dest);

            if(x!=y){
                result[r++] = nextEdge;
                unionSet(x.data,y.data);
            }
        }

        for(int i=0;i<r;i++){
            System.out.println(result[i].src+"--"+result[i].dest+" ->"+result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);
        graph.addEdge(0,1,10);
        graph.addEdge(0,2,6);
        graph.addEdge(0,3,5);
        graph.addEdge(1,3,15);
        graph.addEdge(2,3,4);

        Kruskal(graph);
    }


}
