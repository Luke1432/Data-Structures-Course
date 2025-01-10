import java.util.*;
public class Graph{

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
    public Graph(){
        adjacencyList=new HashMap<>();
    }
    public void addVertex(String vertex){
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }
    public void addEdge(String from, String to, int weight){
        adjacencyList.get(from).add(new Edge(to,weight));
    }

    public void print(){
        for(String vertex:adjacencyList.keySet()){
            System.out.println(vertex+"->"+adjacencyList.get(vertex));
        }
    }
    public static void main(String[] args) {
        Graph graph=new Graph();

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

    }
}