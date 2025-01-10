import java.util.HashMap;

public class InventoryManager {
    private HashMap<String, Integer> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void put(String item, int quantity) {
        inventory.put(item, quantity);
    }

    public int get(String item) {
        return inventory.getOrDefault(item, 0);
    }

    public void remove(String item) {
        inventory.remove(item);
    }

    public boolean containsKey(String item) {
        return inventory.containsKey(item);
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        
        manager.put("Apples", 10);
        manager.put("Bananas", 20);

        System.out.println("Apples: " + manager.get("Apples"));
        System.out.println("Bananas: " + manager.get("Bananas"));

        System.out.println("Contains Oranges? " + manager.containsKey("Oranges"));
        manager.remove("Apples");
        System.out.println("Contains Apples? " + manager.containsKey("Apples"));
    }
}
