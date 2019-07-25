package DSA.Graphs;

import java.util.*;

public class TopologicalSorting {

    static int index =0;
    static List<Letter> letters = new LinkedList<>();
    static class Letter{
        int ind;
        char c;

        Letter(char c){
            this.c = c;
            this.ind = index++;
        }
    }
    static class Graph{
        int v;
        LinkedList<Letter>[] adjList;

        Graph(){
            this.v =index;
            adjList = new LinkedList[index];

            for(int i=0;i<v;i++){
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(Letter src, Letter dest){
            adjList[src.ind].add(dest);
        }

        Stack<Character> topoSort(){
            boolean[] visited = new boolean[v];
            Stack<Character> st = new Stack<>();

            for(Letter lt:letters){
                if(!visited[lt.ind]){
                    topoSortUtil(lt, visited, st);
                }
            }
            return st;
        }

        private void topoSortUtil(Letter s, boolean[] visited, Stack<Character> st) {

            visited[s.ind] = true;
            ListIterator<Letter> it = adjList[s.ind].listIterator();
            Letter lt = null;

            while(it.hasNext()){
                lt = it.next();
                if(!visited[lt.ind]){
                    topoSortUtil(lt, visited, st);}
            }
            st.push(s.c);
        }
    }

    public static void main(String[] args) {

        Letter a = new Letter('a');
        Letter b = new Letter('b');
        Letter c = new Letter('c');
        Letter d = new Letter('d');
        Letter e = new Letter('e');
        Letter f = new Letter('f');

        letters.add(a);
        letters.add(b);
        letters.add(c);
        letters.add(d);
        letters.add(e);
        letters.add(f);
        Graph g = new Graph();

        g.addEdge(f,c);
        g.addEdge(f,a);
        g.addEdge(e,b);
        g.addEdge(e,a);
        g.addEdge(c,d);
        g.addEdge(d,b);

        Stack<Character> st = g.topoSort();
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }

    }
}
