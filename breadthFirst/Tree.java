public class Tree {
    Node root;

    boolean isEmpty(){
        return root == null;
    }

    void addNote(int data){
        if (isEmpty())
            root = new Node(data);
        
        else{
            Node p,prev = null;
            p = root;

            while(p != null){
                prev = p;
                if (data<p.getData())
                    p = p.getLeft();
                else
                    p = p.getRight();
            }
            if (data<prev.getData())
                prev.setLeft(new Node(data));
            else
                prev.setRight(new Node(data));
        }
    }

}
