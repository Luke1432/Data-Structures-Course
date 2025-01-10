import java.util.*;


/**
* Represents a campus map with locations and pathways.
*/
public class CampusMap {
   protected Map<Location, List<Location>> adj = new HashMap<>();


   /**
    * Adds a location to the campus map.
    *
    * @param loc the location to be added
    */
   public void addLocation(Location loc) {
       // TODO - implement adding a location (PART 1)
       if (!adj.containsKey(loc)) {
           adj.put(loc, new ArrayList<>());
       }
   }


   /**
    * Adds a pathway between two locations.
    *
    * @param loc1 the first location
    * @param loc2 the second location
    */
   public void addPath(Location loc1, Location loc2) {
       // TODO - implement adding a path (PART 1)
       if (!adj.containsKey(loc1)) {
           addLocation(loc1);
       }
       if (!adj.containsKey(loc2)) {
           addLocation(loc2);
       }
       adj.get(loc1).add(loc2);
       adj.get(loc2).add(loc1);
   }


   /**
    * Prints the campus map with all locations and their connected pathways.
    */
   public void print() {
       // TODO - implement a method to print the map textually (PART 1)
       for (Map.Entry<Location, List<Location>> entry : adj.entrySet()) {
           Location loc = entry.getKey();
           List<Location> connectedLocations = entry.getValue();
           System.out.print(loc.getName() + " has a pathway to: ");
           for (Location connected : connectedLocations) {
               System.out.print(connected.getName() + ", ");
           }
           System.out.println(); // Newline after each location
       }
   }


   /**
    * Finds the shortest route between two locations based on the specified access level.
    *
    * @param start  the starting location
    * @param end    the destination location
    * @param access the access level (OT, DC, or AL)
    * @return the shortest route between the start and end locations, or null if no route is found
    */
   public List<Location> shortestRoute(Location start, Location end, Access access) {
       if (start == null || end == null || !adj.containsKey(start) || !adj.containsKey(end)) {
           return null; // No valid start or end location
       }


       Queue<List<Location>> queue = new LinkedList<>();
       Set<Location> visited = new HashSet<>();


       // Start BFS with the starting location
       queue.add(List.of(start));
       visited.add(start);


       while (!queue.isEmpty()) {
           List<Location> path = queue.poll();
           Location current = path.get(path.size() - 1);


           // If we reach the end location, return the path
           if (current.equals(end)) {
               return path;
           }


           // Explore neighbors
           for (Location neighbor : adj.get(current)) {
               if (!visited.contains(neighbor) && isAccessible(neighbor, access)) {
                   visited.add(neighbor);


                   // Create a new path and add it to the queue
                   List<Location> newPath = new ArrayList<>(path);
                   newPath.add(neighbor);
                   queue.add(newPath);
               }
           }
       }


       return null; // No path found
   }


   // Helper method to check if a location is accessible based on access level
   private boolean isAccessible(Location location, Access access) {
       return location.getAccess() == Access.AL || location.getAccess() == access;
   }


   public List<List<Location>> findAllRoutes(Location start, Location end, Access access) {
       List<List<Location>> allPaths = new ArrayList<>();
       Set<Location> visited = new HashSet<>();
       List<Location> currentPath = new ArrayList<>();


       // Start DFS from the starting location
       findAllPathsDFS(start, end, access, visited, currentPath, allPaths);


       return allPaths;
   }


   /**
    * Finds all possible routes between two locations based on the specified access level.
    *
    * @param start  the starting location
    * @param end    the destination location
    * @param access the access level (OT, DC, or AL)
    * @return a list of all possible routes between the start and end locations
    */




   /**
    * Finds all possible paths between two locations based on the specified access level using Depth-First Search.
    *
    * @param current the current location being explored
    * @param end     the destination location
    * @param access  the access level (OT, DC, or AL)
    * @param visited a set of visited locations to avoid revisiting
    * @param path    the current path being explored
    * @param allPaths a list to store all found paths
    */
   private void findAllPathsDFS(Location current, Location end, Access access,
                                Set<Location> visited, List<Location> path, List<List<Location>> allPaths) {


       if (current == null || end == null || !adj.containsKey(current)) {
           return;
       }


       // Mark current location as visited and add to the path
       visited.add(current);
       path.add(current);


       // If we reach the destination, add the current path to the list of all paths
       if (current.equals(end)) {
           allPaths.add(new ArrayList<>(path));
       } else {
           // Explore neighbors
           for (Location neighbor : adj.get(current)) {
               if (!visited.contains(neighbor) && isAccessible(neighbor, access)) {
                   findAllPathsDFS(neighbor, end, access, visited, path, allPaths);
               }
           }
       }


       // Backtrack: remove the current location and mark it as unvisited
       path.remove(path.size() - 1);
       visited.remove(current);
   }


   
//    public static void main(String[] args) {
//        // Create locations
//        Location fBldg = new Location("F Bldg", "F", Access.AL);
//        Location dBldg = new Location("D Bldg", "D", Access.AL);
//        Location aBldg = new Location("A Bldg", "A", Access.AL);
//        Location eBldg = new Location("E Bldg", "E", Access.AL);
//        Location bBldg = new Location("B Bldg", "B", Access.AL);
//        Location cBldg = new Location("C Bldg", "C", Access.AL);


//        // Create campus map
//        CampusMap campusMap = new CampusMap();


//        // Add locations to the map
//        campusMap.addLocation(fBldg);
//        campusMap.addLocation(dBldg);
//        campusMap.addLocation(aBldg);
//        campusMap.addLocation(eBldg);
//        campusMap.addLocation(bBldg);
//        campusMap.addLocation(cBldg);


//        // Add pathways between locations
//        campusMap.addPath(fBldg, aBldg);
//        campusMap.addPath(fBldg, dBldg);
//        campusMap.addPath(fBldg, eBldg);
//        campusMap.addPath(dBldg, eBldg);
//        campusMap.addPath(aBldg, bBldg);
//        campusMap.addPath(eBldg, bBldg);
//        campusMap.addPath(eBldg, fBldg);
//        campusMap.addPath(bBldg, cBldg);


//        // Print the campus map
//        campusMap.print();
//    }




}
