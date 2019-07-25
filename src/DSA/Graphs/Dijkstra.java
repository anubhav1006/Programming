package DSA.Graphs;

import java.util.Arrays;

public class Dijkstra {

    static int size =9;

    static int minKey(int[]dist, boolean[]spt){
        int min=Integer.MAX_VALUE, minKey=0;

        for(int i=0;i<dist.length;i++){
            if(!spt[i]){
                if(min>dist[i]){
                    min = dist[i];
                    minKey = i;
                }
            }
        }

        return minKey;
    }

    static void dj(int[][] graph, int source){
        int[] dist = new int[size];
        boolean[] spt = new boolean[size];


        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for(int i=0;i<size;i++){
            int u = minKey(dist, spt);

            spt[u] = true;
            for(int j=0;j<size;j++){
                if(graph[u][j]!=0 && dist[j]>graph[u][j]+dist[u]&&!spt[j]){
                    dist[j]= graph[u][j]+dist[u];
                }
            }
        }

        for(int i=0;i<size;i++){
            System.out.println(source+" -- "+i+" -> "+ dist[i]);
        }
    }

    public static void main (String[] args)
    {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        dj(graph, 0);
    }
}
