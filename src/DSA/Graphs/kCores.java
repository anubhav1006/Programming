package DSA.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class kCores {

    static class Graph {
        int v;
        LinkedList<Integer>[] ll;
        boolean compatible[];


        Graph(int v) {
            this.v = v;
            ll = new LinkedList[v];
            compatible = new boolean[v];
            for (int i = 0; i < v; i++) {
                ll[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, int dest) {
            ll[src].add(dest);
            ll[dest].add(src);
        }

        void printCores(int k) {
            boolean[] visited = new boolean[v];
            int[] degree = new int[v];

            int min_deg = Integer.MAX_VALUE;
            int start=0;

            for (int i = 0; i < v; i++) {
                degree[i] = ll[i].size();

                if(degree[i]<min_deg){
                    min_deg = degree[i];
                    start = i;
                }
            }

            dfsUtil(start, visited, degree, k);

            for (int i = 0; i < v; i++) {
                if(!visited[i])
                    dfsUtil(i, visited, degree, k);
            }

            for (int i = 0; i < v; i++) {
                if(degree[i]>=k){

                    System.out.print("["+i+"] ");
                    Iterator<Integer> it = ll[i].listIterator();
                    while(it.hasNext()){
                        int n = it.next();
                        if(degree[n]>=k)
                            System.out.print("-> "+ n);
                    }
                    System.out.println("");
                }

            }
        }

        private boolean dfsUtil(int i, boolean[] visited, int[] degree, int k) {
            visited[i] = true;

            Iterator<Integer> it = ll[i].listIterator();
            while (it.hasNext()) {
                int n= it.next();
                if (degree[i] < k) {
                    degree[n]--;
                }

                if(!visited[n]){
                    if(dfsUtil(n, visited, degree, k)){
                        degree[i]--;
                    }
                }
            }

            return degree[i]<k;
        }

      /*  void kCores(int k){

            kCoresUtil(k);
            boolean[] visited = new boolean[v];

            dfsUtil(0, visited);

        }
        void kCoresUtil(int k){
           for(int i=0;i<v;i++) {
                if(ll[i].size()<k){
                    compatible[i]=false;
                }
           }
        }
        private void removeEdge(int s, int d){
            ll[s].remove(d);
            ll[d].remove(s);
        }


        private void dfsUtil(int s, boolean[] visited) {
            visited[s]=true;
            Iterator<Integer> it = ll[s].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(!compatible[n]){
                    removeEdge(s, n);
                }
                if(!visited[n]){
                    dfsUtil(n, visited);
                }
            }
        }

        *//*int size(LinkedList<Integer> ll){
            int size=0;
            Iterator it = ll.listIterator();
            while (it.hasNext()){
                it.next();
                size++;
            }

            return size;
        }*//*

        void printCores(){
            for(int i=0;i<v;i++){
                if(ll[i].size()>1){
                    Iterator<Integer> it = ll[i].listIterator();
                    while(it.hasNext()){
                        int n = it.next();
                        System.out.println(n + " -> ");
                    }
                }
            }
        }*/


    }

    public static void main(String[] args) {
        Graph g1 = new Graph(9);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(2, 6);
        g1.addEdge(3, 4);
        g1.addEdge(3, 6);
        g1.addEdge(3, 7);
        g1.addEdge(4, 6);
        g1.addEdge(4, 7);
        g1.addEdge(5, 6);
        g1.addEdge(5, 8);
        g1.addEdge(6, 7);
        g1.addEdge(6, 8);

        g1.printCores(3);
    }
}
