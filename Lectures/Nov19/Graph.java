import java.util.*;

public class Graph{
    HashMap<String, ArrayList<String>> adjacencyList;
    public Graph(){
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

    public void dfs(String start, ArrayList<String> visited){
        if(visited.contains(start)){
            return;
        }
        visited.add(start);
        System.out.println(start);
        for(String s:adjacencyList.get(start)){
            dfs(s,visited);
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
        graph.dfs("A", new ArrayList<>());

    }
}