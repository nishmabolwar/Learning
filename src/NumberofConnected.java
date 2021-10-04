import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.HashSet;

public class NumberofConnected {
    public int connected(int n, int[][] edges) {
        int count =0;
     //if (edges.length != n - 1) return 0;

    int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
        int x = find(edge[0], parent);
        int y = find(edge[1], parent);

      if (x == y) count=count+1 ;
//            parent[x] = y;
     //   else
        parent[x] = y;
    }
        HashSet<Integer> set=new HashSet<>();
      for( int i:parent){
          if(i<0) count++;
      }
      return count;
}
    int find(int node, int[] parent) {
        //Characters c:
        if (parent[node] == -1) return node;

        return parent[node] = find(parent[node], parent);
    }
    int find1 ( int node, int[] parent){
        while(parent[node] != -1) node = parent[node];
        return node;
    }

    public static void main(String args[])
    {
        int[][] edge=new int[][] {{0, 0}, {1,1}, {2, 3}};
        //int[][] edge=new int[][] {{0, 1}, {0,2}, {0, 3},{1,4}};
        NumberofConnected n=new NumberofConnected();
        System.out.println(n.connected(5,edge));
    }
}
