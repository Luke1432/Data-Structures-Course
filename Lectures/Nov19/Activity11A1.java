import java.util.*;

public class Activity11A1{
    HashMap<String, ArrayList<String>> adjacencyList;
    public Activity11A1(){
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

    public static void main(String[] args) {
        Activity11A1 graph=new Activity11A1();
        graph.addVertex("Luffy");
        graph.addVertex("Garp");
        graph.addVertex("Ace");
        graph.addVertex("Roger");
        graph.addVertex("Sabo");
        graph.addVertex("Dragon");
        graph.addVertex("Nami");
        graph.addVertex("Nojiko");
        graph.addVertex("Zoro");
        graph.addVertex("Ryuma");
        graph.addEdge("Luffy", "Garp");
        graph.addEdge("Luffy", "Ace");
        graph.addEdge("Luffy", "Sabo");
        graph.addEdge("Luffy", "Nami");
        graph.addEdge("Luffy", "Zoro");
        graph.addEdge("Luffy", "Dragon");
        graph.addEdge("Dragon", "Garp");
        graph.addEdge("Ace", "Roger");
        graph.addEdge("Ace", "Sabo");
        graph.addEdge("Ace", "Nami");
        graph.addEdge("Sabo", "Luffy");
        graph.addEdge("Nami", "Nojiko");
        graph.addEdge("Zoro", "Ryuma");
        graph.addEdge("Zoro", "Nami");
        graph.addEdge("Zoro", "Ace");

        graph.print();

    }
}