import java.util.*;

public class Activity11A2{
    HashMap<String, ArrayList<String>> adjacencyList;
    public Activity11A2(){
        adjacencyList=new HashMap<>();
    }
    public void addVertex(String key){
        adjacencyList.putIfAbsent(key, new ArrayList<>());
    }
    public void addEdge(String v1, String v2){
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    public void print(){
        for(String vertex:adjacencyList.keySet()){
            System.out.println(vertex+" -> "+adjacencyList.get(vertex));
        }
    }

    public void bfs(String start, String end){
        Queue<String> queue = new LinkedList<>();
        Map<String, String> previous = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()){        
            String current = queue.poll();
            
            if (current.equals(end)) {
                break;
            }

            for(String neighbor : adjacencyList.get(current)){
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = end;
        
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);

        if (path.get(0).equals(start)) {
            System.out.println("Shortest path from " + start + " to " + end + ": " + path);
        } else {
            System.out.println("No path found from " + start + " to " + end);
        }
    }


    public static void main(String[] args) {
        Activity11A2 graph=new Activity11A2();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "F");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("D", "G");
        graph.addEdge("E", "F");

        graph.print();
        graph.bfs("A","G");

    }
}