package DSA.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    static class Graph {

        int V;
        LinkedList<Integer>[] edges;
        boolean[] visited;

        Graph(int V) {
            this.V = V;
            edges = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                edges[i] = new LinkedList<>();
            }
        }

        private void addEdge(int src, int dest) {
            edges[src].add(dest);
        }

        private boolean[] initVisited() {
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            return visited;
        }

        private void dfs(int s) {

            visited = initVisited();
            runDFS(s);
        }

        private void runDFS(int s) {

            visited[s] = true;
            System.out.print(s + ", ");
            Iterator<Integer> i = edges[s].listIterator();
            while (i.hasNext()) {

                int n= i.next();
                if (!visited[n]) {
                    runDFS(n);
                }

            }
        }

        private void bfs(int s) {

            LinkedList<Integer> queue = new LinkedList<>();
            visited = initVisited();
            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                s = queue.poll();
                System.out.print(s + ", ");

                Iterator<Integer> i = edges[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }


        }

        private void modifiedBfs(int s, int level) {

            LinkedList<Integer> queue = new LinkedList<>();
            int[] levels = new int[V];
            visited = initVisited();
            visited[s] = true;
            queue.add(s);
            levels[s] = 0;

            while (queue.size() != 0) {
                s = queue.poll();
                System.out.print(s + ", ");

                Iterator<Integer> i = edges[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        levels[n] = levels[s]+1;
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            System.out.println("");
            for(int i=0;i<V;i++){
                if(levels[i]==level)
                    System.out.print(i+", ");
            }


        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
/*

        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(3, 4);
        //graph.addEdge(3, 3);
*/

        g.dfs(0);
       // System.out.println("New");
    }
}
