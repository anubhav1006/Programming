package DSA.Graphs.AMPrep;

public class Dijkistra {
    static int v =9;
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

    private static void dj(int[][] graph, int src) {
        int[] dist = new int[v];
        boolean[] sptSet = new boolean[v];

        for(int i=0;i<v;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        for(int c =0;c<v;c++){
            int u = minKey(dist, sptSet);

            sptSet[u] = true;
            for(int j=0;j<v;j++){
                if(graph[u][j]!=0 && !sptSet[j] && dist[j]>dist[u]+graph[u][j]){
                    dist[j]=dist[u]+graph[u][j];
                }
            }
        }

        for(int i=0;i<v;i++){
            System.out.println(i+"--->"+dist[i]);
        }
    }

    private static int minKey(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE;
        int min_idx = -1;

        for(int i=0;i<dist.length;i++){
            if(!sptSet[i] && dist[i]<min){
                min = dist[i];
                min_idx = i;
            }
        }

        return min_idx;
    }
}
