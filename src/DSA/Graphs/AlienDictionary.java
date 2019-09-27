package DSA.Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class AlienDictionary {
    static class Graph{
        int v;
        LinkedList<Character>[] adjlist;
        boolean[] visited;

        public Graph(int v) {
            this.v = v;
            adjlist = new LinkedList[v];
            visited = new boolean[v];
            for(int i=0;i<v;i++){
                adjlist[i] = new LinkedList<>();
            }
        }

        private void addEdge(int a, char b){
            adjlist[a].add(b);
        }
    }

    public static void main(String[] args) {
        String[] words = {"caa", "aaa", "aab"};
        int noOfAlphabets = 3;
        printOrder(words, noOfAlphabets);
    }

    private static void printOrder(String[] words, int n) {
        Graph g=  new Graph(n);

        for(int i=0;i<words.length-1;i++){
            String a = words[i];
            String b = words[i+1];

            for(int j=0;j<a.length();j++){
                if (a.charAt(j)!=b.charAt(j)){
                    g.addEdge(a.charAt(j)-'a', b.charAt(j));
                    break;
                }
            }
        }

        Stack<Character> st = new Stack<>();
        for(int i =0;i<n;i++) {
            if(!g.visited[i])
                topoSortutil(i, g, st);
        }

        while(!st.isEmpty()){
            System.out.print(st.pop()+", ");
        }


    }

    private static void topoSortutil(int a, Graph g, Stack<Character> st) {
        g.visited[a] =true;
        Iterator<Character> it = g.adjlist[a].listIterator();
        while (it.hasNext()){
            char x = it.next();
            if(!g.visited[x-'a']){
                topoSortutil(x-'a', g, st);
            }
        }
        st.push((char)('a'+ a));
    }
}
