import java.util.ArrayList;

class Course1 {

    public static void main(String args[]){
        Course1 course1=new Course1();
        System.out.println(course1.canFinish(2,new int[][]{{1,0}}));
    }
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0)
            return true;


        ArrayList[] graph = new ArrayList[numCourses];
        boolean[] dp = new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs1(graph,visited,i, dp))
                return false;
        }
        return true;
    }

    private boolean dfs1(ArrayList[] graph, boolean[] visited, int course, boolean [] dp){
        if(visited[course])
            return dp[course];
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs1(graph,visited,(int)graph[course].get(i), dp))
            {
                return false;
            }
        }
        dp[course] = true;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create Array of lists -> adjecency matrix of graph
        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        // Fill all the nodes (0 to numCourses - 1) as array index holding newly created arraylists
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Fill the arraylists of each nodes with their outgoing edges/connected nodes
        for(int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }

        // Define an array of visited (0 -> unvisited, 1 -> visited, 2 -> completed), initially filled with 0's
        int[] visited = new int[numCourses];

        // Do DFS for each of the array nodes to check a cycle
        for(int i=0; i<numCourses; i++) {
            if( !dfs(i, visited, adj))
                return false;
        }

        return true;
    }

    public boolean dfs(int node, int[] visited, ArrayList<Integer>[] adj) {
        // Return false if the node is visited and viewed again before completion
        if(visited[node] == 1) {
            return false;
        }

        // Return true if the node is completed processing
        if(visited[node] == 2) {
            return true;
        }

        // Mark the node as visited
        visited[node] = 1;

        // DFS of all the other nodes current "node" is connected to
        for(int n : adj[node]) {
            if(!dfs(n, visited, adj))
                return false;
        }

        // If no more other nodes for the current "node" mark as completed and return true

        visited[node] = 2;

        return true;
    }

}
