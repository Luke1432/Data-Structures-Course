public class NAryTree{
    //attributes of a tree
    TernaryNode root;

    //constructor
    NAryTree(){
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
        printTree(node.right,depth+1);
    }


    public static void main(String[] args) {
        Tree tree=new Tree();
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

    }
}

class NAryNode{
    char val;
    TernaryNode left;
    TernaryNode right;

    //constructor
    NAryNode(char val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}