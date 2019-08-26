package DSA.Algos;

import java.util.*;

public class LRU_Cache {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            Set<Integer> s = new HashSet<Integer>() ;
            int n = sc.nextInt();
            LRUCache g = new LRUCache(n);
            int q = sc.nextInt();

            while(q>0)
            {

                String c = sc.next();
                //	System.out.println(c);
                if(c.equals("GET"))
                {
                    int x = sc.nextInt();
                    System.out.print(g.get(x)+" ");
                }
                if(c.equals("SET"))
                {
                    int x = sc.nextInt();
                    int y  = sc.nextInt();
                    g.set(x,y);
                }

                q--;
                //System.out.println();
            }
            t--;
            System.out.println();
        }
    }


static class LRUCache {

    Map<Integer,Integer> map;
    Queue<Integer> q;
    int capacity;
    int index;
    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        //Your code here
        map = new HashMap<>();
        q = new LinkedList<>();
        capacity = N;


    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        //Your code here
        index=0;
        if(map.containsKey(x)){
            Iterator<Integer> it = q.iterator();
            while(it.hasNext()){
                int i = it.next();
                if(i==x){
                    index = i;
                    break;
                }
            }
            q.remove(index);
            q.add(index);
            return map.get(x);
        }else{
            return -1;
        }
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        //Your code here
        index=0;
        if(!map.containsKey(x)){
            if(q.size()<capacity){
                q.add(x);
            }else{
                int key = q.remove();
                map.remove(key);
                q.add(x);
            }
        }else{
            Iterator<Integer> it = q.iterator();
            while(it.hasNext()){
                int i = it.next();
                if(i==x){
                    index = i;
                    break;
                }
            }
            q.remove(index);
            q.add(index);
        }
        map.put(x,y);
    }
}


}
