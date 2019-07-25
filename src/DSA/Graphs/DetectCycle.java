package DSA.Graphs;


public class DetectCycle {

    static int edgeCounter = 0;

    static class Graph {
        int v;
        int e;
        //LinkedList<Edges>[] adjList;
        Edges[] edges;

        Graph(int v, int e) {
            this.v = v;
            this.e = e;
            /*adjList = new LinkedList[v];
            for(int i=0;i<v;i++){
                adjList[i] = new LinkedList<>();
            }*/
            edges = new Edges[this.e];
        }

        class Edges {
            int src, dest;
            int weight;

            Edges(int s, int d, int w) {
                src = s;
                dest = d;
                weight = w;
            }

            Edges(int s, int d) {
                src = s;
                dest = d;
            }
        }

        void addEdge(int src, int dest) {
            Edges edge = new Edges(src, dest);
            edges[edgeCounter++] = edge;
        }
    }

    static class Subset{
        int parent, rank;
    }

    static int detectCycleOptimized(Graph g){
        Subset[] subsets= new Subset[g.v];

        for(int i=0;i<g.v;i++){
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        for(int i=0;i<g.e;i++){
            int x = find(subsets, g.edges[i].src);
            int y = find(subsets, g.edges[i].dest);

            if(x == y)
                return 1;
            union(subsets, x,y);
        }
        return 0;
    }

    static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets,
                    subsets[i].parent);
        return subsets[i].parent;
    }


    static void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if(subsets[xRoot].rank<subsets[yRoot].rank)
            subsets[xRoot].parent = yRoot;

        else if(subsets[xRoot].rank>subsets[yRoot].rank)
            subsets[yRoot].parent = xRoot;

        else{
            subsets[xRoot].parent = yRoot;
            subsets[yRoot].rank++;
        }
    }

    /*static int detectCycle(Graph g) {
        int[] parent = new int[g.v];

        for (int i = 0; i < g.v; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < g.e; i++) {
            int x = find(parent, g.edges[i].src);
            int y = find(parent, g.edges[i].dest);

            if (x == y)
                return 1;

            union(parent, x, y);
        }
        return 0;
    }*/

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

        if (detectCycleOptimized(graph) == 1)
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }
}
