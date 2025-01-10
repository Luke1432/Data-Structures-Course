import java.util.*;

public class Activity12A2 {
    HashMap<String, ArrayList<String>> adjacencyList;
    HashMap<String, Integer> edgeWeights;


    public Activity12A2() {
        adjacencyList = new HashMap<>();
        edgeWeights = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        adjacencyList.get(from).add(to);
        edgeWeights.put(from + "->" + to, weight);
    }

    public List<String> findSinks() {
        List<String> list = new ArrayList<>();
        for (String key : adjacencyList.keySet()) {
            if (adjacencyList.get(key).isEmpty()) {
                list.add(key);
            }
        }
        return list;
    }

    public int countInDegree(String vertex) {
        int inDegree = 0;
        for (String key : adjacencyList.keySet()) {
            if (adjacencyList.get(key).contains(vertex)) {
                inDegree++;
            }
        }
        return inDegree;
    }

    public int totalWeight() {
        int total = 0;
        for (int weight : edgeWeights.values()) {
            total += weight;
        }
        return total;
    }

    public List<String> makeAllPaths(String start, String end) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(start);
        dfs(start, end, path, result, 0);
        return result;
    }

    private void dfs(String current, String end, List<String> path, List<String> result, int cost) {
        if (current.equals(end)) {
            result.add(String.join(" -> ", path) + " | Cost: " + cost);
            return;
        }

        if (!adjacencyList.containsKey(current)) return;

        for (String neighbor : adjacencyList.get(current)) {
            if (!path.contains(neighbor)) { 
                path.add(neighbor);
                dfs(neighbor, end, path, result, cost + edgeWeights.get(current + "->" + neighbor));
                path.remove(path.size() - 1);
            }
        }
    }

    public void print() {
        for (String vertex : adjacencyList.keySet()) {
            System.out.println(vertex + " -> " + adjacencyList.get(vertex));
        }
    }

    public static void main(String[] args) {
        Activity12A2 graph = new Activity12A2();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "F", 4);
        graph.addEdge("B", "C", 3);
        graph.addEdge("C", "A", 1);
        graph.addEdge("C", "E", 6);
        graph.addEdge("C", "D", 2);
        graph.addEdge("D", "E", 1);
        graph.addEdge("D", "F", 7);
        graph.addEdge("D", "G", 5);
        graph.addEdge("E", "F", 3);
        graph.addEdge("F", "D", 4);

        graph.print();

        System.out.println("Total Weight of Graph: " + graph.totalWeight());

        System.out.println("All paths from A to G:");
        List<String> paths = graph.makeAllPaths("A", "G");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
