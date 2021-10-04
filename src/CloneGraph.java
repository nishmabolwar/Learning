import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    static HashMap<Node, Node> map = new HashMap<>();
    static Queue<Node> queue=new ArrayDeque<>();

        public static Node cloneGraph(Node node){

            queue.offer(node);
            map.put(node, new Node(node.val, new ArrayList<>()));
            while (!queue.isEmpty()) {
                Node h = queue.poll();

                for (Node neighbor : h.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        queue.offer(neighbor);
                    }
                    map.get(h).neighbors.add(map.get(neighbor));
                }
            }

            return map.get(node);
        }


    public static void main(String args[]){
        ArrayList<Node> neighbors=new ArrayList<>();
        neighbors.add(new Node(2,new ArrayList<>()));
        neighbors.add(new Node(3,new ArrayList<>()));
        Node input=new Node(1,  neighbors);
        System.out.println(cloneGraph(input));
    }
}
