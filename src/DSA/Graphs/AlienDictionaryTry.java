package DSA.Graphs;

import java.util.*;

public class AlienDictionaryTry {


    static class Graph{
        int v;
        LinkedList<Character>[] adjList;
        boolean[] visited;

        public Graph(int v) {
            this.v = v;
            adjList = new LinkedList[v];
            visited = new boolean[v];
            for (int i=0;i<v;i++){
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, char dest){
            adjList[src].add(dest);

        }
    }

    public static void main(String[] args) {
        String[] words = {"caa", "aaa", "aab"};
        int noOfAlphabets = 3;
        printOrder(words, noOfAlphabets);
    }
    static Stack<Character> st = new Stack<>();

    private static void printOrder(String[] words, int count) {
        int n = words.length;
        Graph g =  new Graph(count);
        for(int i=0;i<n-1;i++){
            String a = words[i];
            String b = words[i+1];

            int j = (a.length()>b.length())? b.length():a.length();
            while(j>0){
                if(a.charAt(j-1)!=b.charAt(j-1)){
                    g.addEdge(a.charAt(j-1)-97, b.charAt(j-1));
                    break;
                }
                j--;
            }
        }
        for(int i=0;i<count;i++){
            if(!g.visited[i])
                topoSort(g,i);
        }

        while (!st.empty()){
            System.out.print(st.pop()+" ");
        }
    }

    private static void topoSort(Graph g,int src) {

        g.visited[src] = true;
        Iterator<Character> it = g.adjList[src].listIterator();
        char c;
        while(it.hasNext()){
            c = it.next();
            if(!g.visited[c-97]){
                topoSort(g,c-97);
            }
        }
        st.push((char)(src+'a'));
    }
}
