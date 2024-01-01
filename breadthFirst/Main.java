public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int dataSet [] = {50,  30,  55,  8,  54,  60,  7,  12,  58,  15
        };
        
        for (int i=0;i<dataSet.length;i++)
            tree.addNote(dataSet[i]);

        Queue queue = new LinkedQueue();
        queue.enqueue(tree.root);
        while (!queue.isEmpty()){
            Node node = queue.dequeue();
            System.out.print(node.getData() +", ");

            if(node.getLeft()!=null){
                queue.enqueue(node.getLeft());
            }
            
            if(node.getRight()!=null){
                queue.enqueue(node.getRight());
            }
        }
        
    }
    
}
