import java.util.*;

public class Activity11A3{
    HashMap<String, ArrayList<String>> adjacencyList;
    public Activity11A3(){
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

    public void bfs(String start){
        Queue<String> queue=new LinkedList<>();
        ArrayList<String> visited=new ArrayList<>();

        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()){
            String current=queue.poll();
            visited.add(current);
            System.out.println(current);
            for(String s:adjacencyList.get(current)){
                if(!visited.contains(s)){
                    queue.offer(s);
                    visited.add(s);
                }
            }
        }
    }

    public List<List<String>> dfs(String start, String end, ArrayList<String> visited, List<String> currentPath) {
        List<List<String>> allPaths = new ArrayList<>();

        visited.add(start);
        currentPath.add(start);

        if (start.equals(end)) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (String neighbor : adjacencyList.get(start)) {
                if (!visited.contains(neighbor)) {
                    allPaths.addAll(dfs(neighbor, end, visited, currentPath));
                }
            }
        }

        currentPath.remove(currentPath.size() - 1);
        visited.remove(visited.size() - 1);

        return allPaths;
    }


    public static void main(String[] args) {
        Activity11A3 graph=new Activity11A3();
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
        ArrayList<String> visited = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        System.out.println(graph.dfs("A", "G", visited, currentPath));

    }
}