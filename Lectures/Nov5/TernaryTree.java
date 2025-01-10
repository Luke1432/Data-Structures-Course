public class TernaryTree{
    //attributes of a tree
    TernaryNode root;

    //constructor
    TernaryTree(){
        this.root=null;
    }

    //Method to print the tree (for testing purposes)
    void printTree(TernaryNode node,int depth){
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
        printTree(node.middle,depth+1);
        printTree(node.right,depth+1);
    }


    public static void main(String[] args) {
        TernaryTree tTree=new TernaryTree();
        TernaryNode a=new TernaryNode('A');
        TernaryNode b=new TernaryNode('B');
        TernaryNode c=new TernaryNode('C');
        TernaryNode d=new TernaryNode('D');
        TernaryNode e=new TernaryNode('E');
        TernaryNode f=new TernaryNode('F');
        TernaryNode g=new TernaryNode('G');
        TernaryNode h=new TernaryNode('H');
        TernaryNode i=new TernaryNode('I');
        TernaryNode j=new TernaryNode('J');
        TernaryNode k=new TernaryNode('K');
        TernaryNode l=new TernaryNode('L');

        tTree.root=a;
        a.left = b;
        a.middle = d;
        a.right = c;

        b.left = e;
        b.middle = f;
        b.right = g;

        c.left = i;
        c.middle = j;
        c.right = k;

        e.left = h;

        h.middle = l;
        
        tTree.printTree(tTree.root, 0);

    }
}

class TernaryNode{
    char val;
    TernaryNode left;
    TernaryNode right;
    TernaryNode middle;

    //constructor
    TernaryNode(char val){
        this.val=val;
        this.left=null;
        this.right=null;
        this.middle=null;
    }
}