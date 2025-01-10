public class Test{
    public static void main(String[] args) {
        RatingsTree tree=new RatingsTree();
        tree.insert("Jonah Hex (2010)", 11, "Action");
        tree.insert("Jack and Jill", 24, "Comedy");
        tree.insert("Jumper", 47, "Sci-fi");
        tree.insert("The Wedding Planner", 50, "Romance");
        tree.insert("Green Lantern", 57, "Sci-fi");
        tree.insert("Captain America Civil War", 77, "Action");
        tree.insert("Ant-Man", 82, "Sci-fi");
        tree.insert("Spiter-Man Far From home", 82, "Action");
        tree.insert("Captain America The First Avenger", 86, "Action");
        tree.insert("Star Wars Episode IV A New Hope", 88, "Sci-fi");
        
        
        tree.printAll();
        tree.findAllGenre("Action");
        tree.findMoviesLower(70);
    }
}