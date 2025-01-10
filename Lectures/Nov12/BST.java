import java.util.ArrayList;
import java.util.List;

public class BST {
  // BST Attributes
  private Node root;

  // Node class to represent each element in the tree
  static class Node {
    // Node attributes
    int data;
    Node left;
    Node right;

    // Constructor
    public Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  // Constructor for the BST
  public BST() {
    this.root = null;
  }

  // Insertion method for adding a value to the tree
  public void insert(int data) {
    this.root = insertRecursive(root, data);
  }

  // Helper method for recursive insertion
  private Node insertRecursive(Node node, int data) {
    // if spot found, insert data as new node
    if (node == null) {
      return new Node(data);
    }
    // otherwise check if the data is less than or greater than the current value
    // and insert recursively
    if (data < node.data) {
      node.left = insertRecursive(node.left, data);
    } else {
      node.right = insertRecursive(node.right, data);
    }
    // return the node
    return node;
  }

  // Depth-First Search (DFS) method for searching a specific value
  public boolean dfsSearch(int target) {
    return dfsSearchRecursive(this.root, target);
    // begin recursive search at the root
  }

  // Recursive DFS Search helper method
  private boolean dfsSearchRecursive(Node node, int target) {
    // if node reached, it is not found in this branch (our base case)
    if (node == null) {
      return false;
    }
    // Check if the current node contains the target value
    if (node.data == target) {
      return true;
    } else if (node.data > target) {
      return dfsSearchRecursive(node.left, target);
    }
    // Recursively search in the left or right subtrees based on value

    return dfsSearchRecursive(node.right, target);
  }

  // In-order Traversal method
  public void inOrderTraversal() {
    inOrderRecursive(this.root);
  }

  // Helper method for in-order traversal
  private void inOrderRecursive(Node node) {
    if (node != null) {
      inOrderRecursive(node.left);
      System.out.print(node.data + " ");
      inOrderRecursive(node.right);
    }
  }

  // Deletion method for removing a value from the tree
  public void delete(int data) {
    this.root = deleteRecursive(this.root, data);
  }

  // Helper method for recursive deletion
  private Node deleteRecursive(Node node, int data) {
    if (node == null) {
      return null;
    }
    if (data < node.data) {
      node.left = deleteRecursive(node.left, data);
    } else if (data > node.data) {
      node.right = deleteRecursive(node.right, data);
    } else {
      if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      }
      node.data = findMin(node.right);
      node.right = deleteRecursive(node.right, node.data);
    }
    return node;
  }

  // Helper method to find the minimum value in the tree
  private int findMin(Node node) {
    int minValue = node.data;
    while (node.left != null) {
      node = node.left;
      minValue = node.data;
    }
    return minValue;
  }

  // Balancing method (simplified version)
  public void balance() {
    List<Integer> sortedList = new ArrayList<>();
    storeInOrder(this.root, sortedList);
    this.root = buildBalancedTree(sortedList, 0, sortedList.size() - 1);
  }

  // Helper method to perform an in-order traversal and store elements in a sorted list
  private void storeInOrder(Node node, List<Integer> list) {
    if (node != null) {
      storeInOrder(node.left, list);
      list.add(node.data);
      storeInOrder(node.right, list);
    }
  }

  // Helper method to rebuild the tree from the sorted list
  private Node buildBalancedTree(List<Integer> sortedList, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    Node node = new Node(sortedList.get(mid));
    node.left = buildBalancedTree(sortedList, start, mid - 1);
    node.right = buildBalancedTree(sortedList, mid + 1, end);
    return node;
  }

  // Method to print the tree in a visually hierarchical way
  public void printTree() {
    printTreeRecursive(root, "", true);
  }

  // Helper method to print the tree recursively
  private void printTreeRecursive(Node node, String indent, boolean isLeft) {
    if (node == null) {
      return;
    }
    System.out.println(indent + (isLeft ? "L--- " : "R--- ") + node.data);
    printTreeRecursive(node.left, indent + (isLeft ? "|   " : "    "), true);
    printTreeRecursive(node.right, indent + (isLeft ? "|   " : "    "), false);
  }

  public static void main(String[] args) {
    BST bst = new BST();
    // Insertion
    bst.insert(7);
    bst.insert(4);
    bst.insert(11);
    bst.insert(2);
    bst.insert(5);
    bst.insert(1);
    bst.insert(3);
    bst.insert(10);
    bst.insert(14);
    bst.insert(9);

    bst.printTree();

    // DFS Search
    System.out.println("DFS Search for 3: " + bst.dfsSearch(3)); // true
    System.out.println("DFS Search for 100: " + bst.dfsSearch(100)); // false

    // In-order Traversal
    System.out.print("In-order Traversal: ");
    bst.inOrderTraversal();
    System.out.println();

    // Deletion
    bst.delete(3);
    System.out.println("after Deletion of 3: ");
    bst.printTree();

    // Balancing
    BST unbalancedBst = new BST();
    unbalancedBst.insert(20);
    unbalancedBst.insert(10);
    unbalancedBst.insert(5);
    unbalancedBst.insert(11);
    unbalancedBst.insert(2);
    unbalancedBst.insert(8);
    unbalancedBst.insert(15);
    unbalancedBst.insert(14);
    unbalancedBst.insert(16);
    unbalancedBst.insert(13);
    unbalancedBst.insert(17);

    System.out.println("unbalanced tree: ");
    unbalancedBst.printTree();

    // Balancing
    unbalancedBst.balance();
    System.out.println("after Balancing: ");
    unbalancedBst.printTree();
  }
}
