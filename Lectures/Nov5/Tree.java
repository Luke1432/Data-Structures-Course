
import java.util.LinkedList;
import java.util.Queue;

public class Tree{
    //attributes of a tree
    Node root;

    //constructor
    Tree(){
        this.root=null;
    }
    

    public void add(char value) {
        Node newNode = new Node(value);
        if (root == null) {
        root = newNode; // If the tree is empty, set the new node as root
        return;
        }

        // Use a queue to perform BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Start with the root node

        while (!queue.isEmpty()) {
        Node current = queue.poll(); // Get and remove the current node from the queue

        // Check for left child
        if (current.left == null) {
            current.left = newNode; // Add the new node here
            return;
        } else {
            queue.add(current.left); // Otherwise, add the left child to the queue
        }

        // Check for right child
        if (current.right == null) {
            current.right = newNode; // Add the new node here
            return;
        } else {
            queue.add(current.right); // Otherwise, add the right child to the queue
        }
        }
    }

    //Method to print the tree (for testing purposes)
    void printTree(Node node,int depth){
        //if leaf reached, return
        if(node==null){
            return;
        }

        //indent by depth
        for(int i=0; i<depth; i++){
            System.out.print("  ");
        }

        //print the value
        System.out.println(node.val);

        //recursively print subtrees as increased depth
        printTree(node.left,depth+1);
        printTree(node.right,depth+1);
    }


    public static void main(String[] args) {
        Tree tree=new Tree();
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');
        Node g=new Node('G');
        Node h=new Node('H');
        Node i=new Node('I');
        Node j=new Node('J');
        Node k=new Node('K');

        
        tree.root=a;
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;
        d.left=h;
        e.left=i;
        e.right=j;
        g.left=k;

        tree.printTree(tree.root, 0);

        tree.add('L');

        tree.add('M');

        tree.printTree(tree.root, 0);

        tree.remove(a.val);
        tree.printTree(tree.root, 0);


    }

    private Node removeRecursive(Node node, int value) {
    if (node == null) {
      return null; // Base case: node is not found
    }
    // If the node to be removed is found
    if (node.val == value) {
      // Case 1: Node with two children
      if (node.left != null && node.right != null) {
        // Promote the left child
        Node promoted = node.left;
        // Attach the right child to the left child
        if (promoted.right == null) {
          promoted.right = node.right; // Attach right child directly
        } else {
          // Find the rightmost node of the left child
          Node rightmost = promoted;
          while (rightmost.right != null) {
            rightmost = rightmost.right;
          }
          rightmost.right=node.right; // Attach right child to the rightmost of the left child
        }
        return promoted; // Promote the left child
      } else {
        // Case 2: Node with only one or no children
        return (node.left != null) ? node.left : node.right;
      }
    }

    // Recursively search for the node to remove in left and right subtrees
    node.left = removeRecursive(node.left, value);
    node.right = removeRecursive(node.right, value);

    return node; // Return the current node
  }

    public void remove(int value) {
    root = removeRecursive(root, value);
  }


}

class Node{
    char val;
    Node left;
    Node right;

    //constructor
    Node(char val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}