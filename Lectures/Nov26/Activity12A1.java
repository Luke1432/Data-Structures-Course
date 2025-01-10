import java.util.*;
public class Activity12A1{
    HashMap<String, ArrayList<String>> adjacencyList;
    public Activity12A1(){
        adjacencyList=new HashMap<>();
    }
    public void addVertex(String vertex){
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }
    public void addEdge(String from, String to){
        adjacencyList.get(from).add(to);
    }
    public List<String> findSinks(){
        List<String> list=new ArrayList<>();
        for(String key:adjacencyList.keySet()){
            if(adjacencyList.get(key).isEmpty()){
                list.add(key);
            }
        }
        return list;
        
    }

    public int countInDegree(String vertex){
        int inDegree = 0;
        for (String key : adjacencyList.keySet()) {
            if (adjacencyList.get(key).contains(vertex)) {
                inDegree++;
            }
        }
        return inDegree;
    }

    public void print(){
        for(String vertex:adjacencyList.keySet()){
            System.out.println(vertex+"->"+adjacencyList.get(vertex));
        }
    }
    public static void main(String[] args) {
        Activity12A1 graph=new Activity12A1();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B");
        graph.addEdge("A", "F");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "E");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("D", "G");
        graph.addEdge("E", "F");
        graph.addEdge("F", "D");
        System.out.println(graph.findSinks());

    }
}