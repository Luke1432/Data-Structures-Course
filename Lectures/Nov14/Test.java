public class Test {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        int[] keysToInsert = {10, 20, 30, 40, 50, 25};
        System.out.println("Inserting keys:");
        for (int key : keysToInsert) {
            System.out.print(key + " ");
            tree.insert(key);
        }
        
        System.out.println("\nIn-order traversal after insertions:");
        tree.printInOrder();

        int keyToDelete = 20;
        System.out.println("\nDeleting key: " + keyToDelete);
        tree.delete(keyToDelete);

        System.out.println("In-order traversal after deletion:");
        tree.printInOrder();
    }
}