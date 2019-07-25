package DSA.Graphs;

import java.util.HashMap;
import java.util.Map;

public class DetectCycleOptimized {

    static int edgeCounter=0;
    static class Graph{
        int v,e;
        Edges[] edges;

        Graph(int V, int E){
            this.v = V;
            this.e = E;

            edges = new Edges[e];
            for(int i =0;i<e;i++){
                edges[i] = new Edges();
            }
        }

        class Edges{
            int src;
            int dest;
        }

        void addEdge(int src, int dest){
            edges[edgeCounter].src = src;
            edges[edgeCounter++].dest = dest;
        }

    }

    static private Map<Integer, Node> map = new HashMap();
    static class Node{
        int rank;
        Node parent;
        int data;

        private Node(int data) {
            this.rank = 0;
            this.parent = null;
            this.data = data;
        }
    }

    static Node makeSet(int data){
        Node node = new Node(data);
        node.parent = node;

        map.put(data, node);
        return node;
    }

    static Node findSet(int data){
        return map.get(data);
    }

    static Node findSet(Node node){
        Node parent = node.parent;
        if(node == parent)
            return parent;

        node.parent = findSet(node.parent);

        return node.parent;
    }

    static void unionSet(Node x , Node y){

        Node xSet = findSet(x);
        Node ySet = findSet(y);

        if(xSet==ySet)
            return;

        else{
            if(xSet.rank>ySet.rank){
                ySet.parent = xSet;
            }
            else if(xSet.rank<ySet.rank){
                xSet.parent = ySet.parent;
            }
            else{
                xSet.parent = ySet;
                ySet.rank++;
            }
        }

    }

    static int detectCycle(Graph g){

        for(int i=0;i<g.v;i++){
            makeSet(i);
        }
        for(int i=0;i<g.e;i++){
            Node x = findSet(g.edges[i].src);
            Node y = findSet(g.edges[i].dest);

            Node xSet = findSet(x);
            Node ySet = findSet(y);

            if(xSet.data==ySet.data){
                return 1;
            }
            unionSet(xSet,ySet);
        }
        return 0;
    }

    public static void main(String[] args) {
        /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        /*graph.edges[edgeCounter].src = 0;
        graph.edges[edgeCounter].dest = 1;

        // add edge 1-2
        graph.edges[edgeCounter].src = 1;
        graph.edges[edgeCounter].dest = 2;

        // add edge 0-2
        graph.edges[edgeCounter].src = 0;
        graph.edges[edgeCounter].dest = 2;*/
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);

        if (detectCycle(graph) == 1)
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }
}
