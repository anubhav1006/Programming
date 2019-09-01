package DSA.Graphs;

import java.util.*;

public class CityAttractions {
    static class Graph{
        int v;
        LinkedList<Integer>[] adjacencyList;
        LinkedList<Integer>[] edgeList;


        int[] weight;
        int[] edgeTime;
        int edges;
        Map<Edge, Integer> timeMap;

        static class Edge{
            int src, dest;
            Edge(int src, int dest){
                this.src = src;
                this.dest= dest;
            }
        }

        Graph(int v, int[] weight, int[] edgeTime){
            this.v = v;
            //edges = edgeTime.length;
            adjacencyList = new LinkedList[v];
            timeMap = new HashMap<>();
            /*edgeList = new  ReverseLinkedList[edges];
            for(int i=0;i<edges;i++){
                edgeList[i] = new ReverseLinkedList<>();
            }*/
            this.weight = weight;
            //this.edgeTime = edgeTime;
            //weight = new int[v];
            for(int i=0;i<v;i++){
                adjacencyList[i] = new LinkedList<>();
            }
        }

        private void addEdge(int src, int dest, int time){
            adjacencyList[src].add(dest);
            timeMap.put(new Edge(src, dest), time);
            adjacencyList[dest].add(src);
            timeMap.put(new Edge(dest, src), time);
        }

        private void modifiedDfs() {
            boolean[] visited = new boolean[v];
            Iterator<Integer> i = adjacencyList[0].listIterator();
            int paths = 0;
            while(i.hasNext()){
                paths++;
                i.next();
            }
            dfsUtil(0, visited);
        }
        private void dfsUtil(int s, boolean[] visited){

        }




    }
}
