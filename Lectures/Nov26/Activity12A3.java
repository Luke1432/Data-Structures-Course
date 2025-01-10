import java.util.*;
public class Activity12A3{

    private class Edge{
        String target;
        int weight;
        private Edge(String target, int weight){
            this.target=target;
            this.weight=weight;
        }
        public String toString(){
            return this.target+"("+this.weight+")";
        }
    }

    HashMap<String, ArrayList<Edge>> adjacencyList;
    private Map<String, String> previousNodes;
    public Activity12A3(){
        adjacencyList=new HashMap<>();
    }
    public void addVertex(String vertex){
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }
    public void addEdge(String from, String to, int weight){
        adjacencyList.get(from).add(new Edge(to,weight));
    }

    public Map<String, Integer> dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        previousNodes = new HashMap<>();
        ArrayList<String> visited = new ArrayList<>();
        Map<String, ArrayList<Edge>> graph = adjacencyList;

        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
            previousNodes.put(node, null);
        }
        distances.put(start, 0);

        while (visited.size() < graph.size()) {
            String closestNode = null;
            int smallest = Integer.MAX_VALUE;
            for (String node : distances.keySet()) {
                if (!visited.contains(node) && distances.get(node) < smallest) {
                    closestNode = node;
                    smallest = distances.get(node);
                }
            }
            if (closestNode == null) break;
            visited.add(closestNode);

            for (Edge neighbor : graph.getOrDefault(closestNode, new ArrayList<>())) {
                if (!visited.contains(neighbor.target)) {
                    int newDist = distances.get(closestNode) + neighbor.weight;
                    if (newDist < distances.get(neighbor.target)) {
                        distances.put(neighbor.target, newDist);
                        previousNodes.put(neighbor.target, closestNode);
                    }
                }
            }
        }
        return distances;
    }

    public void shortestPaths(String start) {
        Map<String, Integer> distances = dijkstra(start);

        System.out.println("Shortest paths from " + start + " to:");
        for (String node : distances.keySet()) {
            if (distances.get(node) == Integer.MAX_VALUE) {
                System.out.println(node + ": No path");
            } else {
                List<String> path = new ArrayList<>();
                String current = node;
                while (current != null) {
                    path.add(0, current);
                    current = previousNodes.get(current);
                }
                System.out.println(node + ": "+ distances.get(node));
            }
        }
    }

    public void print(){
        for(String vertex:adjacencyList.keySet()){
            System.out.println(vertex+"->"+adjacencyList.get(vertex));
        }
    }
    public static void main(String[] args) {
        Activity12A3 graph=new Activity12A3();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B",1);
        graph.addEdge("A", "F",1);
        graph.addEdge("B", "C",1);
        graph.addEdge("C", "A",1);
        graph.addEdge("C", "E",1);
        graph.addEdge("C", "D",1);
        graph.addEdge("D", "E",1);
        graph.addEdge("D", "F",1);
        graph.addEdge("D", "G",1);
        graph.addEdge("E", "F",1);
        graph.addEdge("F", "D",1);

        graph.print();
        graph.shortestPaths("A");
        graph.shortestPaths("B");


    }
}