public class Test {
   public static void main(String[] args) {
       // Create a campus map
       CampusMap map = new CampusMap();


       // Create locations
       Location f = new Location("F Bldg", "F", Access.AL);
       Location d = new Location("D Bldg", "D", Access.AL);
       Location a = new Location("A Bldg", "A", Access.AL);
       Location e = new Location("E Bldg", "E", Access.AL);
       Location b = new Location("B Bldg", "B", Access.AL);
       Location c = new Location("C Bldg", "C", Access.AL);


       // Add locations to the map
       map.addLocation(f);
       map.addLocation(d);
       map.addLocation(a);
       map.addLocation(e);
       map.addLocation(b);
       map.addLocation(c);


       map.addPath(f, a);
       map.addPath(f, d);
       map.addPath(f, e);
       map.addPath(d, e);
       map.addPath(d, f);
       map.addPath(a, b);
       map.addPath(a, f);
       map.addPath(e, b);
       map.addPath(e, d);
       map.addPath(e, f);
       map.addPath(b, a);
       map.addPath(b, c);
       map.addPath(b, e);
       map.addPath(c, b);


       System.out.println("Campus Map:");
       map.print();
   }
}
